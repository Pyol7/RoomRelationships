package com.example.roomrelationships.storage.relationships

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomrelationships.storage.tables.Course
import com.example.roomrelationships.storage.tables.CourseEnrollment
import com.example.roomrelationships.storage.tables.Student

/**
 * Since a student can take any number of courses and any number of students can take the same
 * course. We would need to create a table that record pairs of student and the course they take.
 * This is known as a MANY to MANY relationship.
 * To create this we embed the student table, indicate to Room the matching columns on the student
 * (parent) and course (child) tables, and the record of each pair on the courseEnrollment table.
 * This object is then used as the return object of the getStudentWithCourses() query.
 */

data class StudentWithCourses(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "courseId",
        associateBy = Junction(value = CourseEnrollment::class)
    )
    val courses: List<Course>
)
