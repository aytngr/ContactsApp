package com.example.contactsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity (tableName = "persons")
data class Persons(@PrimaryKey(autoGenerate = true )
                    @ColumnInfo(name = "id") @NotNull var id:Int? = 0,
                   @ColumnInfo(name = "name") @NotNull var name:String? = "",
                   @ColumnInfo(name = "phone") @NotNull var phone:String? = "") : Serializable {
}