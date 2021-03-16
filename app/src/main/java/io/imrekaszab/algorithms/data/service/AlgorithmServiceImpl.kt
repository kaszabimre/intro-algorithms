package io.imrekaszab.algorithms.data.service

import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.AlgorithmHolder
import io.imrekaszab.algorithms.data.model.sort.SortAlgorithm
import io.imrekaszab.algorithms.utils.flowOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlgorithmServiceImpl @Inject constructor(
    private val algorithmHolder: AlgorithmHolder,
    private val mockAlgorithmFactory: MockAlgorithmFactory
) : AlgorithmStore, AlgorithmAction {
    private val outputStateFlow = MutableStateFlow("")
    private val outputFlow: Flow<String> = outputStateFlow

    override fun getSelected() = algorithmHolder.getItemFlow()
        .flowOn(Dispatchers.Default)

    override fun getOutput(): Flow<String> = outputFlow

    override fun getAlgorithmList() = flowOf { mockAlgorithmFactory.getAlgorithmList() }
        .flowOn(Dispatchers.Default)

    override suspend fun select(algorithm: Algorithm) = withContext(Dispatchers.Default) {
        outputStateFlow.emit("")
        algorithmHolder.setItem(algorithm)

        return@withContext
    }

    override suspend fun submit() = withContext(Dispatchers.Default) {
        val algorithm = algorithmHolder.getItem()

        if (algorithm is SortAlgorithm) {
            algorithm.outputStateFlow = outputStateFlow
            algorithm.sort()
        }
    }
}