package io.imrekaszab.algorithms.model

import androidx.annotation.StringRes
import io.imrekaszab.algorithms.R

class BubbleSort : SortAlgorithm() {
    override val type = AlgorithmType.SORT

    @get:StringRes
    override val titleResId = R.string.algorithm_list_item_bubble
}
