package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class InsertionSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_insertion

    override val performance = AlgorithmPerformance.QUADRATIC

    override suspend fun sort() {
        printCurrentState()
        for (firstUnsortedIndex in 1 until intArray.size) {
            val newElement = intArray[firstUnsortedIndex]
            var i = firstUnsortedIndex

            while (i > 0 && intArray[i - 1] > newElement) {
                intArray[i] = intArray[i - 1]
                i--
            }
            intArray[i] = newElement
            printCurrentState()
        }
    }
}
