package com.example.smartmarketss.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smartmarketss.dao.SmartMarketDao
import com.example.smartmarketss.entities.Users
import com.example.smartmarketss.entities.Productap
import com.example.smartmarketss.entities.Orderap

@Database(entities = [Users::class, Productap::class, Orderap::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun smartMarketDao(): SmartMarketDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "markets_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
