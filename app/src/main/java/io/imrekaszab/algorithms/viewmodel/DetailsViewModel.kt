package io.imrekaszab.algorithms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.imrekaszab.algorithms.data.service.AlgorithmAction
import io.imrekaszab.algorithms.data.service.AlgorithmStore
import io.imrekaszab.algorithms.utils.launchOnDefault
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    algorithmStore: AlgorithmStore,
    private val algorithmAction: AlgorithmAction
) : ViewModel() {

    val algorithm = algorithmStore.getSelected()
        .asLiveData(Dispatchers.Default)

    val output = algorithmStore.getOutput()
        .asLiveData(Dispatchers.Default)

    fun submit() {
        CoroutineScope(Dispatchers.Default).launchOnDefault {
            algorithmAction.submit()
        }
    }
}
