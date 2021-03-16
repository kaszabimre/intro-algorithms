package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class CountingSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_counting

    override val performance = AlgorithmPerformance.LINEAR

    override suspend fun sort() {
        printCurrentState()
        countingSort(intArray, 1, 10)
    }

    private suspend fun countingSort(input: IntArray, min: Int, max: Int) {
        val countArray = IntArray((max - min) + 1)
        for (i in input.indices) {
            countArray[input[i] - min]++
        }
        var j = 0
        for (i in min..max) {
            while (countArray[i - min] > 0) {
                input[j++] = i
                countArray[i - min]--

                printCurrentState()
            }
        }
    }
}
