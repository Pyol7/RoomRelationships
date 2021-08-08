package com.example.roomrelationships.viewModels

import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.roomrelationships.TAG
import com.example.roomrelationships.storage.AppDatabase
import com.example.roomrelationships.storage.relationships.StudentWithBooksAndVehicles
import com.example.roomrelationships.storage.relationships.StudentWithCourses
import com.example.roomrelationships.storage.relationships.StudentWithMedicalRecord
import com.example.roomrelationships.storage.relationships.StudentWithVehicles
import com.example.roomrelationships.storage.tables.StudentMedicalRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentsViewModel(application: Application) : AndroidViewModel(application) {
    private val studentDao = AppDatabase.getInstance(application).studentDao()
    private val studentMedicalRecordDao = AppDatabase.getInstance(application).studentMedicalRecordDao()

    fun getStudentWithMedicalRecord(): LiveData<List<StudentWithMedicalRecord>> {
        return studentDao.getStudentWithMedicalRecord()
    }

    fun getStudentWithCourses(): LiveData<List<StudentWithCourses>> {
        return studentDao.getStudentWithCourses()
    }

    fun getStudentWithVehicles(): LiveData<List<StudentWithVehicles>> {
        return studentDao.getStudentWithVehicles()
    }

    fun getStudentWithBooksAndVehicles(): LiveData<List<StudentWithBooksAndVehicles>> {
        return studentDao.getStudentWithBooksAndVehicles()
    }

    fun insertStudentMedicalRecord(record: StudentMedicalRecord?): LiveData<Long> {
        val result = MutableLiveData<Long>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                result.postValue(studentMedicalRecordDao.insert(record))
            } catch (e: SQLiteException) {
                //handle exception
                Log.i(TAG, "Student with medical record Id#${record?.studentId} already exists.")
                Log.i(TAG, "Try updating the existing record instead.")
                Log.i(TAG, "Exception: ${e.message}")
            }
        }
        return result
    }

}
