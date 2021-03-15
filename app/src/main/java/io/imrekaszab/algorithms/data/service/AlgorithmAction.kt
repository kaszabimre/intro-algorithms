package io.imrekaszab.algorithms.data.service

import io.imrekaszab.algorithms.data.model.Algorithm

interface AlgorithmAction {
    suspend fun select(algorithm: Algorithm)
    suspend fun submit(algorithm: Algorithm)
}
