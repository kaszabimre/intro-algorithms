package io.imrekaszab.algorithms.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.imrekaszab.algorithms.data.service.AlgorithmAction
import io.imrekaszab.algorithms.data.service.AlgorithmServiceImpl
import io.imrekaszab.algorithms.data.service.AlgorithmStore

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceComponent {

    @Binds
    abstract fun bindAlgorithmStore(impl: AlgorithmServiceImpl): AlgorithmStore

    @Binds
    abstract fun bindAlgorithmAction(impl: AlgorithmServiceImpl): AlgorithmAction
}