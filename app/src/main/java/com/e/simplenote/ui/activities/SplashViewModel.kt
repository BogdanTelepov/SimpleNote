package com.e.simplenote.ui.activities

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.e.simplenote.database.AppRoomDatabase
import com.e.simplenote.database.AppRoomRepository
import com.e.simplenote.utilits.REPOSITORY
import com.e.simplenote.utilits.TYPE_ROOM

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    fun initDatabase(type: String) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)

            }
        }

    }

}