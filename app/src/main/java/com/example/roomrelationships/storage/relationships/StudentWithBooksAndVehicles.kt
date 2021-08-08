package com.example.roomrelationships.storage.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrelationships.storage.tables.Book
import com.example.roomrelationships.storage.tables.Student
import com.example.roomrelationships.storage.tables.Vehicle

/**
 * A vehicle and a book can belong to only one student. Therefore in order for a student to have
 * many vehicles and books, we must create a new object that holds ONE student, MANY vehicles
 * and MANY books and use that as the return object of our getStudentWithBooksVehicles() query.
 *
 * We create a new object by embedding the student table (parent) and indicate to Room a column
 * on the student table that matches with a column on the book table (child)
 * and vehicle table (child).
 */

data class StudentWithBooksAndVehicles(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "studentId"
    )
    val books: List<Book>,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "studentId"
    )
    val vehicles: List<Vehicle>
)
