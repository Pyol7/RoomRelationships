package com.example.roomrelationships.storage.daos

import androidx.room.*
import com.example.roomrelationships.storage.tables.Vehicle

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vehicle: Vehicle?)

}
