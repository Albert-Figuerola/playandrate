package com.albanda.playandrate.data.repository.auth

import com.albanda.playandrate.data.room.dao.UserDao
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.model.User
import com.albanda.playandrate.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class AuthRepositoryImpl @Inject constructor(
    @Named("IODispatcher") private val coroutineScope: CoroutineScope,
    private val firebaseAuth: FirebaseAuth,
    private val userDao: UserDao
): AuthRepository {
    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser

    override val isUserAuthenticated: Boolean
        get() = firebaseAuth.currentUser != null

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Response.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun signUp(user: User): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).await()
            Response.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
        coroutineScope.launch {
            userDao.clearUser()
        }
    }
}