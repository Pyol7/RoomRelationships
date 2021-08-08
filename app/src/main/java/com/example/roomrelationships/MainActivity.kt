package com.example.roomrelationships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.roomrelationships.viewModels.StudentsViewModel

const val TAG = "RoomRelationships"
class MainActivity : AppCompatActivity() {
    private val studentsVm: StudentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        deleteDatabase("app_database")

        studentsVm.getStudentWithCourses().observe(this){
            Log.i(TAG, "$it")
        }
    }
}
