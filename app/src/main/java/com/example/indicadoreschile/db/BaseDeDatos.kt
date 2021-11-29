package com.example.indicadoreschile.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.indicadoreschile.model.db.*


@Database(entities = [UF::class, Dolar::class, Euro::class, UTM::class, Bitcoin::class],
    version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun dao() : IndiceDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDeDatos? = null

        fun getDataBase(context: Context): BaseDeDatos {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "indice_db"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}