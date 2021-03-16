package io.imrekaszab.algorithms.data.model

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

abstract class SortAlgorithm(val intArray: IntArray) : Algorithm() {
    override val type = AlgorithmType.SORT

    abstract suspend fun sort(outputFlow: MutableStateFlow<String>)

    fun swap(i: Int, j: Int) {
        if (i == j) {
            return
        }

        val temp = intArray[i]
        intArray[i] = intArray[j]
        intArray[j] = temp
    }

    suspend fun printCurrentState(outputFlow: MutableStateFlow<String>) {
        var currentText = ""
        for (index in intArray.indices) {
            currentText = currentText + intArray[index].toString() + "   "
        }

        val state = outputFlow.value + "\n\n" + currentText

        outputFlow.emit(state)
        delay(300L)
    }
}
