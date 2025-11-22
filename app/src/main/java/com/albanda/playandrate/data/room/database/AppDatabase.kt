package com.albanda.playandrate.data.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.albanda.playandrate.data.model.entity.user.UserEntity
import com.albanda.playandrate.data.room.dao.UserDao


@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}