package io.imrekaszab.algorithms.data.model

abstract class Algorithm {
    abstract val type: AlgorithmType
    abstract val performance: AlgorithmPerformance
    abstract val titleResId: Int
}
