package com.example.lecture_1a_7.di

import com.example.lecture_1a_7.data.repository.NoteRepositoryImpl
import com.example.lecture_1a_7.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun noteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository
}