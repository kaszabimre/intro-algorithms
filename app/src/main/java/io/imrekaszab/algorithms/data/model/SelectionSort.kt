package io.imrekaszab.algorithms.data.model

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import kotlinx.coroutines.flow.MutableStateFlow

class SelectionSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_selection

    override val performance = AlgorithmPerformance.QUADRATIC

    override suspend fun sort(outputFlow: MutableStateFlow<String>) {
        printCurrentState(outputFlow)
        for (lastUnsortedIndex in intArray.size - 1 downTo 1) {
            var largest = 0
            for (i in 1..lastUnsortedIndex) {
                if (intArray[i] >= intArray[largest]) {
                    largest = i
                }
            }
            swap(largest, lastUnsortedIndex)
            printCurrentState(outputFlow)
        }
    }
}
