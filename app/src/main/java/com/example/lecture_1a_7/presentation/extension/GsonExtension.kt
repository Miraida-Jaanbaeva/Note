package com.example.lecture_1a_7.presentation.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


inline fun <reified T> String.fromJson(): T = Gson().fromJson<T>(this, object: TypeToken<T>() {}.type)

fun <T> T.toJson(): String = Gson().toJson(this)