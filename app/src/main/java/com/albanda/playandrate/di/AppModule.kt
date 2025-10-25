package com.albanda.playandrate.di

import com.albanda.playandrate.core.Constants.POSTS
import com.albanda.playandrate.core.Constants.USERS
import com.albanda.playandrate.data.repository.auth.AuthRepositoryImpl
import com.albanda.playandrate.data.repository.post.PostRepositoryImpl
import com.albanda.playandrate.data.repository.user.UserRepositoryImpl
import com.albanda.playandrate.domain.repository.AuthRepository
import com.albanda.playandrate.domain.repository.PostRepository
import com.albanda.playandrate.domain.repository.UserRepository
import com.albanda.playandrate.domain.usecase.auth.AuthUseCases
import com.albanda.playandrate.domain.usecase.auth.GetCurrentUser
import com.albanda.playandrate.domain.usecase.auth.Login
import com.albanda.playandrate.domain.usecase.auth.Logout
import com.albanda.playandrate.domain.usecase.auth.Signup
import com.albanda.playandrate.domain.usecase.post.CreateLikePost
import com.albanda.playandrate.domain.usecase.post.CreatePost
import com.albanda.playandrate.domain.usecase.post.DeleteLikePost
import com.albanda.playandrate.domain.usecase.post.DeletePost
import com.albanda.playandrate.domain.usecase.post.GetPosts
import com.albanda.playandrate.domain.usecase.post.GetPostsByUserId
import com.albanda.playandrate.domain.usecase.post.PostUseCases
import com.albanda.playandrate.domain.usecase.post.UpdatePost
import com.albanda.playandrate.domain.usecase.user.CreateUser
import com.albanda.playandrate.domain.usecase.user.GetUserById
import com.albanda.playandrate.domain.usecase.user.SaveImage
import com.albanda.playandrate.domain.usecase.user.UpdateUser
import com.albanda.playandrate.domain.usecase.user.UserUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Named(USERS)
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference = storage.reference.child(USERS)

    @Provides
    @Named(USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository = authRepositoryImpl

    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl

    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(authRepository),
        login = Login(authRepository),
        logout = Logout(authRepository),
        signup = Signup(authRepository)
    )

    @Provides
    fun provideUserUseCases(userRepository: UserRepository) = UserUseCases (
        createUser = CreateUser(userRepository),
        getUserById = GetUserById(userRepository),
        updateUser = UpdateUser(userRepository),
        saveImage = SaveImage(userRepository)
    )

    @Provides
    fun providePostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository = postRepositoryImpl

    @Provides
    fun providePostUseCases(postRepository: PostRepository) = PostUseCases (
        createPost = CreatePost(postRepository),
        getPosts = GetPosts(postRepository),
        getPostsByUserId = GetPostsByUserId(postRepository),
        deletePost = DeletePost(postRepository),
        updatePost = UpdatePost(postRepository),
        createLikePost = CreateLikePost(postRepository),
        deleteLikePost = DeleteLikePost(postRepository)
    )

    @Provides
    @Named(POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference = storage.reference.child(POSTS)

    @Provides
    @Named(POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POSTS)

}