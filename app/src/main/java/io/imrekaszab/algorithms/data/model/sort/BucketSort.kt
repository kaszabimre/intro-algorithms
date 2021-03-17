package io.imrekaszab.algorithms.data.model.sort

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance

class BucketSort(array: IntArray) : SortAlgorithm(array) {
    @StringRes
    override val titleResId = R.string.algorithm_list_item_bucket

    override val performance = AlgorithmPerformance.LINEAR

    override suspend fun sort() {
        printCurrentState()
        val buckets: Array<ArrayList<Int>?> = arrayOfNulls(10)
        for (i in buckets.indices) {
            // using linked lists for the buckets
            //buckets[i] = new LinkedList<Integer>();

            // using arraylists as the buckets
            buckets[i] = ArrayList()
        }
        for (i in intArray.indices) {
            buckets[hash(intArray[i])]?.add(intArray[i])
        }
        for (bucket in buckets) {
            bucket?.sort()
        }

        var j = 0
        for (i in buckets.indices) {
            for (value in buckets[i]!!) {
                intArray[j++] = value
            }
            printCurrentState()
        }
    }

    private fun hash(value: Int) = value / 10
}
