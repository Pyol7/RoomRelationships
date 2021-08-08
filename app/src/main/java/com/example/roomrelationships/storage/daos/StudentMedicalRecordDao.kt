package com.example.roomrelationships.storage.daos

import androidx.room.*
import com.example.roomrelationships.storage.tables.StudentMedicalRecord

@Dao
interface StudentMedicalRecordDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(record: StudentMedicalRecord?): Long

}
