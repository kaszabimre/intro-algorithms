package io.imrekaszab.algorithms.data.model

import kotlinx.coroutines.flow.MutableStateFlow

abstract class Algorithm {
    abstract val type: AlgorithmType
    abstract val performance: AlgorithmPerformance
    abstract val titleResId: Int

    lateinit var outputStateFlow: MutableStateFlow<String>
}
