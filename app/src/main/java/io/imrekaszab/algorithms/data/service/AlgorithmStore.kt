package io.imrekaszab.algorithms.data.service

import io.imrekaszab.algorithms.data.model.Algorithm
import kotlinx.coroutines.flow.Flow

interface AlgorithmStore {
    fun getSelected(): Flow<Algorithm>
    fun getOutput(): Flow<String>
    fun getAlgorithmList(): Flow<List<Algorithm>>
}
