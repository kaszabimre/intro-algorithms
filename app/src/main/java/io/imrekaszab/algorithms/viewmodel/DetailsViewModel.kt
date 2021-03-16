package io.imrekaszab.algorithms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.imrekaszab.algorithms.data.service.AlgorithmAction
import io.imrekaszab.algorithms.data.service.AlgorithmStore
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    algorithmStore: AlgorithmStore,
    algorithmAction: AlgorithmAction
) : ViewModel() {

    val algorithm = algorithmStore.getSelected()
        .asLiveData(Dispatchers.Default)
}
