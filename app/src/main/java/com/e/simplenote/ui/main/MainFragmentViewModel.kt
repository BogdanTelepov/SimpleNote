package com.e.simplenote.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.e.simplenote.database.AppRoomDatabase
import com.e.simplenote.database.AppRoomRepository
import com.e.simplenote.utilits.REPOSITORY
import com.e.simplenote.utilits.TYPE_ROOM

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {



    val allNotes = REPOSITORY.allNotes




}