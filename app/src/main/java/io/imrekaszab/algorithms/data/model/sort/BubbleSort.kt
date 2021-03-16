package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class BubbleSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_bubble

    override val performance = AlgorithmPerformance.QUADRATIC

    override suspend fun sort() {
        for (lastUnsortedIndex in intArray.size - 1 downTo 1) {
            for (i in 0 until lastUnsortedIndex) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(i, i + 1)
                    printCurrentState()
                }
            }
        }
    }
}
