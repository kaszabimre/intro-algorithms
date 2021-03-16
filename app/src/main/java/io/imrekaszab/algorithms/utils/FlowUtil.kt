package io.imrekaszab.algorithms.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> flowOf(factory: () -> T): Flow<T> = flow {
    emit(factory())
}
