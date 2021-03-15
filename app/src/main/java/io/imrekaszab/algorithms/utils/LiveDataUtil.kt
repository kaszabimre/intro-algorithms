package io.imrekaszab.algorithms.utils

import androidx.lifecycle.LiveData

fun <T : Any> LiveData<T>.require() = requireNotNull(value) { "Value is not set" }
