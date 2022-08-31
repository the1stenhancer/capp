package com.the1stenhancer.capp.data.source.local


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesRegionLocalSource(): RegionLocalSource =
        RegionLocalSource()
}