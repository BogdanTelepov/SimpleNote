package com.e.simplenote.ui.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.e.simplenote.model.AppNote
import com.e.simplenote.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun delete(appNote: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(appNote) {
                onSuccess()
            }
        }
    }
}