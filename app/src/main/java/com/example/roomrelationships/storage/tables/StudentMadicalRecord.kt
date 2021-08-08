package com.example.roomrelationships.storage.tables

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A medical record can belong to only one student.
 * By adding a unique index on this entity, we can enforce that any given studentId only appears
 * once inside this table. This fosters a true one-to-one relationship.
 * The @Insert OnConflictStrategy on the Dao now determines how Room reacts to an attempt to
 * insert another record with a studentId that already existing in the table.
 * OnConflictStrategy.ABORT - would throw an exception.
 * OnConflictStrategy.REPLACE - overwrites the record with matching studentIds.
 * OnConflictStrategy.IGNORE - does just that.
 *
 * Having a separate table has two main advantages:
 * (1) Data size concerns. Let’s say we want to request information about all of the students,
 * but we don’t need to care about their medical records. Separating the data into two entities
 * allows us to request only the data we actually need.
 * (2) Security. This may not be common in Android applications, but in other database systems
 * you may want some information to be in a separate database that has different permissions,
 * but still keep a one-to-one relationship with information in another database.
 */

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["studentId"],
            childColumns = ["studentId"]
        )
    ],
    indices = [Index(value = ["studentId"], unique = true)]
)
data class StudentMedicalRecord(
    @PrimaryKey(autoGenerate = true)
    val medicalRecordId: Long = 0L,
    val studentId: Long = 0L,
    val medicalRecord: String = ""
)
