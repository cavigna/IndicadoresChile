package com.example.indicadoreschile.utils

import android.annotation.SuppressLint

import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.DateFormat
import java.text.DateFormat.getDateInstance
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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



fun montoToUSD(monto: Double):String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "US"))
    format.maximumFractionDigits = 0
    //format.currency = Currency.getInstance( "CLP")

    return format.format(monto.roundToInt())
}

@SuppressLint("NewApi")
fun fechaApi(fechaLoca: String): String{
    //"fecha": "2021-11-04T03:00:00.000Z", 04-11-2021
    val inputDate= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH)
    val fecha = LocalDate.parse(fechaLoca, inputDate)

    return outputFormatter.format(fecha)
}

@RequiresApi(Build.VERSION_CODES.O)
fun formateamelafecha(fechaString: String):Date{
    //val inputTimeString = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(fechaString)

    return date
    //val date = getDateInstance()

}


fun formateameElValor(string: String):Double{
    val format = NumberFormat.getInstance(Locale.ITALIAN)
    val number = format.parse(string)
    return number.toDouble()
}

/*
DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
LocalDate date = LocalDate.parse("2018-04-10T04:00:00.000Z", inputFormatter);
String formattedDate = outputFormatter.format(date);
 */
/*
fun Double.toRidePrice():String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("NGN")

    return format.format(this.roundToInt())
}
 */



