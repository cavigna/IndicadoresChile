package com.example.indicadoreschile.utils

import android.annotation.SuppressLint

import android.icu.util.Calendar
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


fun fromTimestamp(value: Long?): Date? {
    return value?.let { Date(it) }
}


fun dateToTimestamp(date: Date?): Long? {
    return date?.time?.toLong()
}

@SuppressLint("NewApi")
fun dameLaFecha():String{

    val currentTime: Calendar = Calendar.getInstance()
    val currentDate: Date = fromTimestamp(currentTime.timeInMillis)!!
    val sdf = SimpleDateFormat("dd-MM-yyyy")

    return sdf.format(currentDate)
}



fun montoToCLP(monto: Double):String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
    format.maximumFractionDigits = 0
    //format.currency = Currency.getInstance( "CLP")

    return format.format(monto.roundToInt())
}

/*
fun Double.toRidePrice():String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("NGN")

    return format.format(this.roundToInt())
}
 */



