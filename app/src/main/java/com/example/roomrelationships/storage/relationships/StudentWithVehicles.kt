package com.example.roomrelationships.storage.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrelationships.storage.tables.Student
import com.example.roomrelationships.storage.tables.Vehicle

/**
 * A vehicle can belong to only one student. Therefore in order for a student to have many vehicles
 * we must create an object that holds ONE student and MANY vehicles and use that as the
 * return object of our getStudentWithVehicles() query.
 *
 * We create a new object by embedding the student table and indicate to Room the matching
 * columns on the student table (parent) and vehicle table (child).
 */

data class StudentWithVehicles(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "studentId"
    )
    val vehicles: List<Vehicle>
)
