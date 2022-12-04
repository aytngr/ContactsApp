package com.example.contactsapp.room

import androidx.room.*
import com.example.contactsapp.data.entity.Persons

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons")
    suspend fun loadPersons(): List<Persons>

    @Query("SELECT * FROM persons WHERE name like '%' || :searchText || '%'")
    suspend fun search(searchText: String): List<Persons>

    @Insert
    suspend fun save(person: Persons)

    @Update
    suspend fun update(person: Persons)

    @Delete
    suspend fun delete(person: Persons)

}