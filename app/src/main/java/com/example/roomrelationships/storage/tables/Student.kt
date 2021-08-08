package com.example.roomrelationships.storage.tables
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentId: Long = 0L,
    val firstName: String = "",
    val lastName: String = "",
)
