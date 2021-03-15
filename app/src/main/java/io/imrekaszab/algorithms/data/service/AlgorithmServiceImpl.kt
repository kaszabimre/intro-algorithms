package io.imrekaszab.algorithms.data.service

import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.BubbleSort
import io.imrekaszab.algorithms.utils.flowOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AlgorithmServiceImpl @Inject constructor() : AlgorithmStore, AlgorithmAction {
    // TODO
    override fun getSelected() = emptyFlow<Algorithm>()

    // TODO
    override fun getAlgorithmList() = flowOf { mutableListOf(BubbleSort())}
        .flowOn(Dispatchers.Default)

    override suspend fun select(algorithm: Algorithm) = withContext(Dispatchers.Default) {
        // TODO
    }

    override suspend fun submit(algorithm: Algorithm) = withContext(Dispatchers.Default) {
        // TODO
    }
}