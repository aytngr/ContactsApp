package com.example.contactsapp.data.datasource

import android.util.Log
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.retrofit.PersonsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonDatasource @Inject constructor(var pdao: PersonsDao) {
    suspend fun save(name:String,phone:String) = pdao.save(name, phone)


    suspend fun update(id:Int,name:String,phone:String){

    }

    suspend fun delete(id:Int) = pdao.delete(id)

    suspend fun loadPersons() : List<Persons>  =
        withContext(Dispatchers.IO){
            pdao.loadPersons().persons
        }

    suspend fun search(searchText:String) : List<Persons>  =
        withContext(Dispatchers.IO){
            pdao.search(searchText).persons
        }

}