package com.example.indicadoreschile.network

sealed class Recurso<T>(val data:T? = null, val message:String? = null){
    class Success<T>(data: T) : Recurso<T>(data)
    class Error<T>(message: String, data: T? =  null): Recurso<T>(data, message)
}