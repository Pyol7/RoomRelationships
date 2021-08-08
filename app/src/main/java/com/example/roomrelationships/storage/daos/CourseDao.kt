package com.example.roomrelationships.storage.daos

import androidx.room.*
import com.example.roomrelationships.storage.tables.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course?)

}
