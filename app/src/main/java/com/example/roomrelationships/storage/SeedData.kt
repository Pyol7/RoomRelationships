package com.example.roomrelationships.storage

import com.example.roomrelationships.storage.tables.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeedData {
    companion object {

        fun insert(instance: AppDatabase) {
            CoroutineScope(Dispatchers.IO).launch {
                students.forEach {
                    instance.studentDao().insert(it)
                }
                vehicles.forEach {
                    instance.vehicleDao().insert(it)
                }
                books.forEach {
                    instance.bookDao().insert(it)
                }
                classes.forEach {
                    instance.courseDao().insert(it)
                }
                classEnrollments.forEach {
                    instance.courseEnrollmentDao().insert(it)
                }

            }
        }

        private val students = arrayListOf(
            Student(firstName = "Justin", lastName = "Romero"),
            Student(firstName = "Levy", lastName = "Romero"),
        )

        private val books = arrayListOf(
            Book(studentId = 1, bookName = "Jack on the bean Stalk"),
            Book(studentId = 2, bookName = "MobiDick"),
            Book(studentId = 2, bookName = "The Bible"),
        )

        private val vehicles = arrayListOf(
            Vehicle( studentId = 1, vehicleType = "Aqua"),
            Vehicle( studentId = 1, vehicleType = "BMW"),
            Vehicle( studentId = 2, vehicleType = "Ford F150"),
        )

        private val classes = arrayListOf(
            Course(courseName = "Android Dev"),
            Course(courseName = "Databases"),
            Course(courseName = "History"),
            Course(courseName = "Spanish")
        )

        private val classEnrollments = arrayListOf(
            CourseEnrollment(courseId = 1, studentId = 1),
            CourseEnrollment(courseId = 2, studentId = 1),
            CourseEnrollment(courseId = 3, studentId = 1),
            CourseEnrollment(courseId = 2, studentId = 2),
            CourseEnrollment(courseId = 3, studentId = 2),
            CourseEnrollment(courseId = 4, studentId = 2)
        )


    }
}