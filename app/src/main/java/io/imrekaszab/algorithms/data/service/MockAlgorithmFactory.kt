package io.imrekaszab.algorithms.data.service

import androidx.annotation.VisibleForTesting
import io.bloco.faker.Faker
import io.imrekaszab.algorithms.data.model.BubbleSort
import io.imrekaszab.algorithms.data.model.MergeSort
import io.imrekaszab.algorithms.data.model.SelectionSort
import javax.inject.Inject

class MockAlgorithmFactory @Inject constructor(private val faker: Faker) {

    fun getAlgorithmList() = arrayListOf(
        bubbleSort(),
        selectionSort(),
        mergeSort()
    )

    @VisibleForTesting
    fun bubbleSort() = BubbleSort(getIntArray())

    private fun selectionSort() = SelectionSort(getIntArray())
    private fun mergeSort() = MergeSort(getIntArray())

    @VisibleForTesting
    fun getIntArray() = IntRange(1, 10)
        .map { faker.number.between(-20, 20) }.toIntArray()
}
