package com.example.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.example.contactsapp.data.datasource.PersonDatasource
import com.example.contactsapp.data.repo.PersonRepository
import com.example.contactsapp.retrofit.ApiUtils
import com.example.contactsapp.retrofit.PersonsDao
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
    fun providePersonDatasource(pdao: PersonsDao) : PersonDatasource {
        return PersonDatasource(pdao)
    }

//    @Provides
//    @Singleton
//    fun providePersonsDao(@ApplicationContext context: Context) : PersonsDao {
//        val db = Room.databaseBuilder(context, MyDatabase::class.java, "contacts.sqlite")
//            .createFromAsset("contacts.sqlite").build()
//        return db.getPersonsDao()
//    }

    @Provides
    @Singleton
    fun providePersonsDao() : PersonsDao {
        return ApiUtils.getPersonsDao()
    }
}