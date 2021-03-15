package io.imrekaszab.algorithms.model;

import androidx.annotation.StringRes;

import io.imrekaszab.algorithms.R;

public class BubbleSort extends SortAlgorithm {

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SORT;
    }

    @Override
    @StringRes
    public int getTitleResId() {
        return R.string.algorithm_list_item_bubble;
    }
}
