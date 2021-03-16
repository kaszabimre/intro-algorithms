package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class ShellSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_shell

    override val performance = AlgorithmPerformance.QUADRATIC

    override suspend fun sort() {
        printCurrentState()
        var gap: Int = intArray.size / 2
        while (gap > 0) {
            for (i in gap until intArray.size) {
                val newElement = intArray[i]
                var j = i
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap]
                    j -= gap
                }
                intArray[j] = newElement
                printCurrentState()
            }
            gap /= 2
        }
    }
}
