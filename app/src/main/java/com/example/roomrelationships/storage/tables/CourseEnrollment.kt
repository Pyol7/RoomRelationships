package com.example.roomrelationships.storage.tables

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

/**
 * Many students can have Many courses.
 */

@Entity(
    primaryKeys = ["studentId", "courseId"],
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["studentId"],
            childColumns = ["studentId"]
        ),
        ForeignKey(
            entity = Course::class,
            parentColumns = ["courseId"],
            childColumns = ["courseId"]
        )
    ],
    indices = [
        Index(value = ["studentId"]),
        Index(value = ["courseId"]),
    ]
)
data class CourseEnrollment(
    val studentId: Long,
    val courseId: Long
)
