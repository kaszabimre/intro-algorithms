package io.imrekaszab.algorithms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.AlgorithmType
import io.imrekaszab.algorithms.data.model.item.AlgorithmItemModel
import io.imrekaszab.algorithms.data.model.item.ItemModel
import io.imrekaszab.algorithms.data.model.item.SectionAlgorithmItemModel
import io.imrekaszab.algorithms.data.service.AlgorithmAction
import io.imrekaszab.algorithms.data.service.AlgorithmStore
import io.imrekaszab.algorithms.utils.launchOnDefault
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    algorithmStore: AlgorithmStore,
    private val algorithmAction: AlgorithmAction
) : ViewModel() {

    val navigateToDetailsSharedFlow = MutableSharedFlow<Any>()

    val algorithms = algorithmStore.getAlgorithmList()
        .map { list ->
            val modelList = arrayListOf<ItemModel>()
            val sortAlgorithms = list.filter { algorithm: Algorithm -> algorithm.type == AlgorithmType.SORT }
            val searchAlgorithms = list.filter { algorithm: Algorithm -> algorithm.type == AlgorithmType.SEARCH }

            if (sortAlgorithms.isNotEmpty()) {
                modelList.add(SectionAlgorithmItemModel(AlgorithmType.SORT))
                modelList.addAll(sortAlgorithms.map { AlgorithmItemModel(it) })
            }

            if (searchAlgorithms.isNotEmpty()) {
                modelList.add(SectionAlgorithmItemModel(AlgorithmType.SEARCH))
                modelList.addAll(searchAlgorithms.map { AlgorithmItemModel(it) })
            }

            return@map modelList
        }
        .asLiveData(Dispatchers.Default)

    fun select(algorithm: Algorithm) {
        CoroutineScope(Dispatchers.Default).launchOnDefault {
            algorithmAction.select(algorithm)
            navigateToDetailsSharedFlow.emit(Any())
        }
    }
}
