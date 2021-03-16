package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class MergeSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_merge

    override val performance = AlgorithmPerformance.N_LOG_STAR_N

    override suspend fun sort() {
        printCurrentState()
        mergeSort(intArray, 0, intArray.size)
    }

    private suspend fun mergeSort(input: IntArray, start: Int, end: Int) {
        if (end - start < 2) {
            return
        }
        val mid = (start + end) / 2
        mergeSort(input, start, mid)
        printCurrentState()
        mergeSort(input, mid, end)
        printCurrentState()
        merge(input, start, mid, end)
        printCurrentState()
    }

    private fun merge(input: IntArray, start: Int, mid: Int, end: Int) {
        if (input[mid - 1] <= input[mid]) {
            return
        }
        var i = start
        var j = mid
        var tempIndex = 0
        val temp = IntArray(end - start)
        while (i < mid && j < end) {
            temp[tempIndex++] = if (input[i] <= input[j]) input[i++] else input[j++]
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i)
        System.arraycopy(temp, 0, input, start, tempIndex)
    }
}
