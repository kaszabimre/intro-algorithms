package io.imrekaszab.algorithms.data.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlgorithmHolder @Inject internal constructor() {

    private val stateFlow = MutableStateFlow<Algorithm?>(null)

    fun setItem(item: Algorithm) {
        stateFlow.tryEmit(item)
    }

    fun getItemFlow() = stateFlow.transform { value ->
        if (value != null) {
            emit(value)
        }
    }

    fun getItem() = stateFlow.value
}