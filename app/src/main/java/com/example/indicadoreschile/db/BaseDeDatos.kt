package com.example.indicadoreschile.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.indicadoreschile.model.db.UFEntity
import com.example.indicadoreschile.model.db.USDEntity
import com.example.indicadoreschile.utils.Converters


@Database(entities = [UFEntity::class, USDEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun dao() : IndicadorDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDeDatos? = null

        fun getDataBase(context: Context): BaseDeDatos {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "indicadores"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}