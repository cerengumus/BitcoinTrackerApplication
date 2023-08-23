package com.cerengumus.bitcointrackerapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cerengumus.bitcointrackerapp.data.local.database.DB.DATABASE_VERSION

@Database(entities = [CoinsListEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class CoinsDatabase : RoomDatabase() {

    abstract fun coinsListDao(): CoinsListDao
}