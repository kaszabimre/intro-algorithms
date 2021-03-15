package io.imrekaszab.algorithms.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.imrekaszab.algorithms.model.AlgorithmType
import io.imrekaszab.algorithms.model.BubbleSort
import io.imrekaszab.algorithms.model.item.AlgorithmItemModel
import io.imrekaszab.algorithms.model.item.SectionAlgorithmItemModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val algorithms = MutableLiveData(
        arrayListOf(
            SectionAlgorithmItemModel(AlgorithmType.SORT),
            AlgorithmItemModel(BubbleSort())
        )
    )
}
