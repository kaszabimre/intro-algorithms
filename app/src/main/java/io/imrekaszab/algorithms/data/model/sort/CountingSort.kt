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
        countingSort(intArray)
    }

    private suspend fun countingSort(arr: IntArray) {
        val arrayLength = arr.size
        if (arrayLength == 0) return
        /** find maximum and minimum values  */
        var max = arr[0]
        var min = arr[0]
        for (i in 1 until arrayLength) {
            if (arr[i] > max) max = arr[i]
            if (arr[i] < min) min = arr[i]
        }
        val range = max - min + 1
        val count = IntArray(range)
        /** initialize the occurrence of each element in the count array  */
        for (i in 0 until arrayLength) {
            count[arr[i] - min]++
        }

        /** calculate sum of indexes  */
        for (i in 1 until range) {
            count[i] += count[i - 1]
        }

        /** modify original array according to the sum count  */
        var j = 0
        for (i in 0 until range) {
            while (j < count[i]) {
                arr[j++] = i + min
            }
        }
        printCurrentState()
    }
}
