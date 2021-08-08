package com.example.roomrelationships.storage

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomrelationships.TAG
import com.example.roomrelationships.storage.tables.*
import com.example.roomrelationships.storage.daos.*

@Database(
    entities = [
        Student::class,
        Book::class,
        Vehicle::class,
        Course::class,
        CourseEnrollment::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun bookDao(): BookDao
    abstract fun courseDao(): CourseDao
    abstract fun courseEnrollmentDao(): CourseEnrollmentDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                /**
                 * This block is executed only once when the app is first installed (Singleton).
                 * As a result the pre-populating coroutine is also launched once.
                 * To re-run this block the app must be uninstalled.
                 */
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            }
            Log.i(TAG, "DB singleton returned")
            return INSTANCE!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                SeedData.insert(INSTANCE!!)
                Log.i(TAG, "DB first run...")
            }
        }

    }
}