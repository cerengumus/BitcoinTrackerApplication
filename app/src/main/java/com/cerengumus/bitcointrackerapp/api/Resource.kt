package com.cerengumus.bitcointrackerapp.api


/**
 * [Resource] is a helper class to wrap the response from backend.
 * [Success] contains the original response.
 * [Error] contains the error message in case of service class error.
 * [Loading] denotes whether there is a network call happening or not
 */
sealed class Resource<out R> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[message=$message]"
            is Loading -> "Loading"
        }
    }
}

val Resource<*>.succeeded
    get() = this is Resource.Success && data != null

//suspend fun <T> Resource(networkCall: suspend () -> Resource<T>): Resource<T> = networkCall.invoke()