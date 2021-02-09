package com.e.simplenote.database

import androidx.lifecycle.LiveData
import com.e.simplenote.model.AppNote

interface DatabaseRepository {

    val allNotes:LiveData<List<AppNote>>

    suspend fun insert(appNote: AppNote, onSuccess:()-> Unit)
    suspend fun delete(appNote: AppNote, onSuccess: () -> Unit)


}