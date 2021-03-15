package io.imrekaszab.algorithms.binding;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import io.imrekaszab.algorithms.R;
import io.imrekaszab.algorithms.model.Algorithm;
import io.imrekaszab.algorithms.model.AlgorithmType;

public final class TextViewBindingAdapters {

    private TextViewBindingAdapters() {
    }

    @BindingAdapter("title")
    public static void bindTitleToTextView(TextView view, Algorithm model) {
        if (model != null) {
            view.setText(view.getResources().getText(model.getTitleResId()));
        }
    }

    @BindingAdapter("sectionTitle")
    public static void bindTitleToTextView(TextView view, AlgorithmType type) {
        if (type == AlgorithmType.SORT) {
            view.setText(R.string.algorithm_list_section_item_sort);
        } else {
            view.setText(R.string.algorithm_list_section_item_search);
        }
    }
}