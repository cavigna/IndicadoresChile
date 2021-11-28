package com.example.indicadoreschile.utils

import android.annotation.SuppressLint
import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.*

class Utilidades {

    companion object{
        @SuppressLint("NewApi")
        val currentTime: Calendar = Calendar.getInstance()
        @SuppressLint("NewApi")
        val currentDate: Date = fromTimestamp(currentTime.timeInMillis)!!



        val sdf :SimpleDateFormat= SimpleDateFormat("dd-MM-yyyy")
        val HOY = sdf.format(currentDate)
        val hoyLong =  SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(HOY).time



    }
}