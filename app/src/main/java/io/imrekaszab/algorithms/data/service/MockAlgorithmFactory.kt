package io.imrekaszab.algorithms.data.service

import io.bloco.faker.Faker
import io.imrekaszab.algorithms.data.model.BubbleSort
import javax.inject.Inject

class MockAlgorithmFactory @Inject constructor(private val faker: Faker) {

    fun getAlgorithmList() = arrayListOf(
        bubbleSort()
    )

    private fun bubbleSort() = BubbleSort(getIntArray())

    private fun getIntArray() = IntRange(1, 10)
        .map { faker.number.between(-20, 20) }.toIntArray()
}
