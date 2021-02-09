package com.e.simplenote.ui.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.e.simplenote.model.AppNote
import com.e.simplenote.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(appNote: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(appNote) {
                onSuccess()
            }

        }
    }
}