package io.imrekaszab.algorithms.data.model.sort

import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.AlgorithmType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

abstract class SortAlgorithm(val intArray: IntArray) : Algorithm() {
    override val type = AlgorithmType.SORT

    abstract suspend fun sort()

    fun swap(i: Int, j: Int) {
        if (i == j) {
            return
        }

        val temp = intArray[i]
        intArray[i] = intArray[j]
        intArray[j] = temp
    }

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
