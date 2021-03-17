package io.imrekaszab.algorithms.data.model.search

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class BinarySearch(array: IntArray) : SearchAlgorithm(array) {

    @StringRes
    override val titleResId = R.string.algorithm_list_item_binary_search

    override val performance = AlgorithmPerformance.LOGARITHMIC

    override suspend fun search() {
        intArray.sort()
        printCurrentState()

        val item = intArray[intArray.size / 2]
        val result = recursiveBinarySearch(intArray, item)

        if (result != -1) {
            val newState = outputStateFlow.value + "\n\n" + "$item was found"
            outputStateFlow.emit(newState)
        }
    }

    private fun iterativeBinarySearch(input: IntArray, value: Int): Int {
        var start = 0
        var end = input.size
        while (start < end) {
            val midpoint = (start + end) / 2
            when {
                input[midpoint] == value -> midpoint
                input[midpoint] < value -> start = midpoint + 1
                else -> end = midpoint
            }
        }
        return -1
    }

    private fun recursiveBinarySearch(input: IntArray, value: Int): Int =
        recursiveBinarySearch(input, 0, input.size, value)

    private fun recursiveBinarySearch(input: IntArray, start: Int, end: Int, value: Int): Int {
        if (start >= end) {
            return -1
        }
        val midpoint = (start + end) / 2
        println("midpoint = $midpoint")
        return if (input[midpoint] == value) {
            midpoint
        } else if (input[midpoint] < value) {
            recursiveBinarySearch(input, midpoint + 1, end, value)
        } else {
            recursiveBinarySearch(input, start, midpoint, value)
        }
    }
}