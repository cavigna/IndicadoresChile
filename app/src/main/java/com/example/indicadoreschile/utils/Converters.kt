package com.example.indicadoreschile.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formateamelafecha(fechaString: String):Date{

        val date = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(fechaString)

        return date


    }
}
