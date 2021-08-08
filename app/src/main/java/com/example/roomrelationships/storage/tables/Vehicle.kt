package com.example.roomrelationships.storage.tables
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A vehicle can belong to only one student.
 * But without a unique studentId index, a studentId may appear many times inside this table.
 * This allows for a one-to-many relationship to be created by another object.
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
data class Vehicle(
    @PrimaryKey(autoGenerate = true)
    val vehicleId: Long = 0L,
    val studentId: Long = 0L,
    val vehicleType: String = ""
)
