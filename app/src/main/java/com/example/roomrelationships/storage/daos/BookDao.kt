package com.example.roomrelationships.storage.daos

import androidx.room.*
import com.example.roomrelationships.storage.tables.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book?)

}
