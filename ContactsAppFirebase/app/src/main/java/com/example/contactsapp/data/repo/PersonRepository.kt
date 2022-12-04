package com.example.contactsapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.data.datasource.PersonDatasource
import com.example.contactsapp.data.entity.Persons

class PersonRepository(var pds:PersonDatasource) {

    suspend fun save(name:String,phone:String) = pds.save(name,phone)

    suspend fun update(id:String,name:String,phone:String) = pds.update(id,name,phone)

    suspend fun delete(id:String) = pds.delete(id)

    fun loadPersons() : MutableLiveData<List<Persons>> = pds.loadPersons()

    fun search(searchText:String) : MutableLiveData<List<Persons>> = pds.search(searchText)
}