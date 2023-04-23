package hu.bme.aut.android.bojackhorseman.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.bojackhorseman.persistence.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


        //        @Provides
//        @Singleton
//        fun provideCharactersDatabase(@ApplicationContext context: Context): AppDatabase {
//            return Room.databaseBuilder(context, AppDatabase::class.java, "")
//                .fallbackToDestructiveMigration()
//                .build()
//        }
        @Provides
        @Singleton
        fun provideCharactersDatabase(@ApplicationContext context: Context) = AppDatabase()

        @Provides
        @Singleton
        fun provideCharactersDAO(appDatabase: AppDatabase) = appDatabase.charactersDao()

}