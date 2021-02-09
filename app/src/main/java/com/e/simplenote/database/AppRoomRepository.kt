package com.e.simplenote.database

import androidx.lifecycle.LiveData
import com.e.simplenote.model.AppNote


class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {


    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(appNote: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(appNote)
        onSuccess()
    }

    override suspend fun delete(appNote: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(appNote)
        onSuccess()
    }


}