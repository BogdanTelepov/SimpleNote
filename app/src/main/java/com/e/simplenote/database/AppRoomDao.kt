package com.e.simplenote.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.e.simplenote.model.AppNote

@Dao
interface AppRoomDao {

    @Query("SELECT * from notes_table ORDER by id DESC")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(appNote: AppNote)

    @Delete
    suspend fun delete(appNote: AppNote)
}