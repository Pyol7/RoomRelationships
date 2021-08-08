package com.example.roomrelationships.storage.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomrelationships.storage.tables.Student
import com.example.roomrelationships.storage.relationships.StudentWithBooksAndVehicles
import com.example.roomrelationships.storage.relationships.StudentWithCourses
import com.example.roomrelationships.storage.relationships.StudentWithMedicalRecord
import com.example.roomrelationships.storage.relationships.StudentWithVehicles

@Dao
interface StudentDao {

    @Query("SELECT * FROM Student")
    @Transaction
    fun getStudentWithMedicalRecord(): LiveData<List<StudentWithMedicalRecord>>

    @Query("SELECT * FROM Student")
    @Transaction
    fun getStudentWithCourses(): LiveData<List<StudentWithCourses>>

    @Query("SELECT * FROM Student")
    @Transaction
    fun getStudentWithVehicles(): LiveData<List<StudentWithVehicles>>

    @Query("SELECT * FROM Student")
    @Transaction
    fun getStudentWithBooksAndVehicles(): LiveData<List<StudentWithBooksAndVehicles>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student?)

}
