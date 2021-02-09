//package com.e.simplenote.ui.start
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import com.e.simplenote.database.AppRoomDatabase
//import com.e.simplenote.database.AppRoomRepository
//import com.e.simplenote.utilits.REPOSITORY
//import com.e.simplenote.utilits.TYPE_ROOM
//
//class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
//
//
//    private val context = application
//
//    fun initDatabase(type: String, onSuccess: () -> Unit) {
//        when (type) {
//            TYPE_ROOM -> {
//                val dao = AppRoomDatabase.getInstance(context).getAppRoomDao()
//                REPOSITORY = AppRoomRepository(dao)
//                onSuccess()
//            }
//        }
//
//    }
//
//}