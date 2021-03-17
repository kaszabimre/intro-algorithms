package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance
import kotlin.math.pow

class RadixSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_radix

    override val performance = AlgorithmPerformance.N_LOG_STAR_N

    override suspend fun sort() {
        printCurrentState()
        radixSort(10, 4)
    }

    private suspend fun radixSort(radix: Int, width: Int) {
        for (i in 0 until width) {
            radixSingleSort(intArray, i, radix)
            printCurrentState()
        }
    }

    private fun radixSingleSort(input: IntArray, position: Int, radix: Int) {
        val numItems = input.size
        val countArray = IntArray(radix)
        for (value in input) {
            countArray[getDigit(position, value, radix)]++
        }
        // Adjust the count array
        for (j in 1 until radix) {
            countArray[j] += countArray[j - 1]
        }
        val temp = IntArray(numItems)
        for (tempIndex in numItems - 1 downTo 0) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex]
        }
        for (tempIndex in 0 until numItems) {
            input[tempIndex] = temp[tempIndex]
        }
    }


    private fun getDigit(position: Int, value: Int, radix: Int): Int =
        value / radix.toDouble().pow(position.toDouble()).toInt() % radix
}
