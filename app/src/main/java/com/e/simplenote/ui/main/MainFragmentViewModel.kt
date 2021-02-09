package com.e.simplenote.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.e.simplenote.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {



    val allNotes = REPOSITORY.allNotes


}