package com.example.roomrelationships.storage.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrelationships.storage.tables.Student
import com.example.roomrelationships.storage.tables.StudentMedicalRecord
import com.example.roomrelationships.storage.tables.Vehicle

/**
 * A student can have only one medical record. Therefore to prevent any chance of a one-to-many
 * relationship being created by another object a unique index is included in the student medical
 * record table.
 * This enforces a true one-to-one relationship.
 * This object is the return object of our getStudentWithMedicalRecord() query.
 *
 * We create a new object by embedding the student table and indicate to Room the matching
 * columns on the student table (parent) and studentMedicalRecord table (child).
 */

data class StudentWithMedicalRecord(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "studentId"
    )
    val medicalRecord: StudentMedicalRecord
)
