package com.example.roomrelationships.storage.tables

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A book can belong to only one student.
 */

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["studentId"],
            childColumns = ["studentId"]
        )
    ],
    indices = [
        Index(value = ["studentId"])
    ]
)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val bookId: Long = 0L,
    val studentId: Long = 0L,
    val bookName: String = ""
)
