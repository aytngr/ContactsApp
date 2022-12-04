package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var prepo:PersonRepository) : ViewModel() {

    var personsList = MutableLiveData<List<Persons>>()

    init {
        loadPersons()
    }

    fun delete(id:String){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.delete(id)
            loadPersons()
        }
    }

    fun loadPersons(){
            personsList = prepo.loadPersons()
    }

    fun search(searchText:String){
            personsList = prepo.search(searchText)
    }
}