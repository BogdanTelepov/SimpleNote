package com.e.simplenote.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_table")
data class AppNote(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val text: String = ""

) : Serializable