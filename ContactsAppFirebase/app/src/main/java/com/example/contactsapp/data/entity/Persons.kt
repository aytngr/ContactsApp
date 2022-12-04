package com.example.contactsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@IgnoreExtraProperties
data class Persons(var id:String? = "",
                   var name:String? = "",
                   var phone:String? = "") : Serializable {
}