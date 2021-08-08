package com.example.roomrelationships.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.example.roomrelationships.storage.AppDatabase
import com.example.roomrelationships.storage.relationships.StudentWithBooksAndVehicles
import com.example.roomrelationships.storage.relationships.StudentWithCourses
import com.example.roomrelationships.storage.relationships.StudentWithVehicles

class StudentsViewModel(application: Application) : AndroidViewModel(application) {
    private val studentDao = AppDatabase.getInstance(application).studentDao()

    fun getStudentWithCourses(): LiveData<List<StudentWithCourses>> {
        return studentDao.getStudentWithCourses()
    }

    fun getStudentWithVehicles(): LiveData<List<StudentWithVehicles>> {
        return studentDao.getStudentWithVehicles()
    }

    fun getStudentWithBooksAndVehicles(): LiveData<List<StudentWithBooksAndVehicles>> {
        return studentDao.getStudentWithBooksAndVehicles()
    }

}
