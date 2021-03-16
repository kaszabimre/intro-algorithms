package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class QuickSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_quick

    override val performance = AlgorithmPerformance.QUADRATIC

    override suspend fun sort() {
        printCurrentState()
        quickSort(intArray, 0, intArray.size)
    }

    private suspend fun quickSort(input: IntArray, start: Int, end: Int) {
        if (end - start < 2) {
            return
        }
        val pivotIndex = partition(input, start, end)
        quickSort(input, start, pivotIndex)
        printCurrentState()
        quickSort(input, pivotIndex + 1, end)
        printCurrentState()
    }

    private fun partition(input: IntArray, start: Int, end: Int): Int {
        val pivot = input[start]
        var i = start
        var j = end
        while (i < j) {
            while (i < j && input[--j] >= pivot) {
                if (i < j) {
                    input[i] = input[j]
                }
            }

            while (i < j && input[++i] <= pivot) {
                if (i < j) {
                    input[j] = input[i]
                }
            }
        }
        input[j] = pivot
        return j
    }
}
