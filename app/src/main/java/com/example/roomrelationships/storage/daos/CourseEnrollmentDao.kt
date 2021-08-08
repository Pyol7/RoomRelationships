package com.example.roomrelationships.storage.daos

import androidx.room.*
import com.example.roomrelationships.storage.tables.CourseEnrollment

@Dao
interface CourseEnrollmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(courseEnrollment: CourseEnrollment?)

}
