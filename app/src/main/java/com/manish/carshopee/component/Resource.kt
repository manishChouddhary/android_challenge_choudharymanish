package com.manish.carshopee.component

sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Loading<T>(val data: T? = null) : Resource<T>()
    class Error<T>(val message: String? = "", val error: Throwable? = null, val data: T? = null) :
        Resource<T>()
}