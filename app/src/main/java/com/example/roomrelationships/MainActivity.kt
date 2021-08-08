package com.example.roomrelationships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.roomrelationships.storage.tables.StudentMedicalRecord
import com.example.roomrelationships.viewModels.StudentsViewModel

const val TAG = "RoomRelationships"
class MainActivity : AppCompatActivity() {
    private val studentsVm: StudentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        deleteDatabase("app_database")

        studentsVm.getStudentWithMedicalRecord().observe(this){
            Log.i(TAG, "$it")
        }

        // Test one-to-one unique index functionality
        val record = StudentMedicalRecord(
            studentId = 2,
            medicalRecord = "Very very healthy"
        )
        val result = studentsVm.insertStudentMedicalRecord(record)
        result.observe(this){
            Log.i(TAG, "Student medical record #${result.value} inserted successfully")
        }

    }
}
