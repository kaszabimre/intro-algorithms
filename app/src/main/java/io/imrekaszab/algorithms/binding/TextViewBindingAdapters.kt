package io.imrekaszab.algorithms.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance
import io.imrekaszab.algorithms.data.model.AlgorithmType

@BindingAdapter("title")
fun TextView.bindTitleToTextView(model: Algorithm?) {
    model ?: return
    text = resources.getText(model.titleResId)
}

@BindingAdapter("sectionTitle")
fun TextView.bindTitleToTextView(type: AlgorithmType?) {
    type ?: return

    setText(
        if (type == AlgorithmType.SORT) {
            R.string.algorithm_list_section_item_sort
        } else {
            R.string.algorithm_list_section_item_search
        }
    )
}

@BindingAdapter("performance")
fun TextView.bindPerformanceToTextView(performance: AlgorithmPerformance?) {
    performance ?: return

    setText(
        when (performance) {
            AlgorithmPerformance.CONSTANT -> R.string.algorithm_list_item_performance_constant
            AlgorithmPerformance.LOGARITHMIC -> R.string.algorithm_list_item_performance_nlogn
            AlgorithmPerformance.LINEAR -> R.string.algorithm_list_item_performance_linear
            AlgorithmPerformance.N_LOG_STAR_N -> R.string.algorithm_list_item_performance_nlogn
            AlgorithmPerformance.QUADRATIC -> R.string.algorithm_list_item_performance_quadratic
        }
    )
}
