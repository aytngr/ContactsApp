package com.example.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.example.contactsapp.data.datasource.PersonDatasource
import com.example.contactsapp.data.repo.PersonRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonRepository(pds:PersonDatasource) : PersonRepository {
        return PersonRepository(pds)
    }

    @Provides
    @Singleton
    fun providePersonDatasource(refContacts: DatabaseReference) : PersonDatasource {
        return PersonDatasource(refContacts)
    }

    @Provides
    @Singleton
    fun provideDatabaseReference() : DatabaseReference {
        return FirebaseDatabase.getInstance().getReference("contacts")
    }

}