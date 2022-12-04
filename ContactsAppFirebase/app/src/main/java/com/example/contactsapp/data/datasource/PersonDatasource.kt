package com.example.contactsapp.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.data.entity.Persons
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDatasource (var refContacts: DatabaseReference) {

    val personList = MutableLiveData<List<Persons>>()

    suspend fun save(name:String,phone:String) {
        val newPerson = Persons("",name,phone)
        refContacts.push().setValue(newPerson)
        Log.i("person","here")
    }


    suspend fun update(id:String,name:String,phone:String){
        val info = HashMap<String,Any>()
        info["name"] = name
        info["phone"] = phone
        refContacts.child(id).updateChildren(info)
    }

    suspend fun delete(id:String) {
        refContacts.child(id).removeValue()
    }

    fun loadPersons() : MutableLiveData<List<Persons>>{
        refContacts.addValueEventListener((object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Persons>()
                for (d in snapshot.children){
                    val person = d.getValue(Persons::class.java)
                    if(person != null) {
                        person.id = d.key
                        list.add(person)
                    }
                }
                personList.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }))
        return personList
    }


    fun search(searchText:String) : MutableLiveData<List<Persons>>{
        refContacts.addValueEventListener((object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Persons>()
                for (d in snapshot.children){
                    val person = d.getValue(Persons::class.java)
                    if(person != null) {
                        if(person.name!!.lowercase().contains(searchText.lowercase())) {
                            person.id = d.key
                            list.add(person)
                        }
                    }
                }
                personList.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }))
        return personList
    }


}