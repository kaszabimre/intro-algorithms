package io.imrekaszab.algorithms.data.service

import androidx.annotation.VisibleForTesting
import io.bloco.faker.Faker
import io.imrekaszab.algorithms.data.model.sort.BubbleSort
import io.imrekaszab.algorithms.data.model.sort.CountingSort
import io.imrekaszab.algorithms.data.model.sort.InsertionSort
import io.imrekaszab.algorithms.data.model.sort.MergeSort
import io.imrekaszab.algorithms.data.model.sort.QuickSort
import io.imrekaszab.algorithms.data.model.sort.RadixSort
import io.imrekaszab.algorithms.data.model.sort.SelectionSort
import io.imrekaszab.algorithms.data.model.sort.ShellSort
import javax.inject.Inject

class MockAlgorithmFactory @Inject constructor(private val faker: Faker) {

    fun getAlgorithmList() = arrayListOf(
        bubbleSort(),
        selectionSort(),
        insertionSort(),
        shellSort(),
        mergeSort(),
        quickSort(),
        countingSort(),
        radixSort()
    )

    @VisibleForTesting
    fun bubbleSort() = BubbleSort(getIntArray())

    private fun selectionSort() = SelectionSort(getIntArray())
    private fun insertionSort() = InsertionSort(getIntArray())
    private fun shellSort() = ShellSort(getIntArray())
    private fun mergeSort() = MergeSort(getIntArray())
    private fun quickSort() = QuickSort(getIntArray())
    private fun countingSort() = CountingSort(getIntArray())
    private fun radixSort() = RadixSort(intArrayOf(4725, 4586, 1330, 8792, 1594, 5729))

    @VisibleForTesting
    fun getIntArray() = IntRange(1, 10)
        .map { faker.number.between(-20, 20) }.toIntArray()
}
