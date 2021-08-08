package com.example.roomrelationships.storage.tables
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey(autoGenerate = true)
    val courseId: Long = 0L,
    val courseName: String = ""
)
