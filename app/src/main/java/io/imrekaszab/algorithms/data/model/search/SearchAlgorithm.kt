package io.imrekaszab.algorithms.data.model.search

import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.AlgorithmType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

abstract class SearchAlgorithm(val intArray: IntArray) : Algorithm() {
    override val type = AlgorithmType.SEARCH

    abstract suspend fun search()

    suspend fun printCurrentState() {
        var currentText = ""
        for (index in intArray.indices) {
            currentText = currentText + intArray[index].toString() + "   "
        }

        val state = outputStateFlow.value + "\n\n" + currentText

        outputStateFlow.emit(state)
        delay(300L)
    }
}
