package com.example.busschedule.data

import android.content.Context

/**
 * Dependency container
 */
interface AppContainer {
    val busScheduleRepository: BusScheduleRepository
}

/**
 * Default implementation of app container using offline database
 */
class DefaultAppContainer(context: Context) : AppContainer{
    override val busScheduleRepository: BusScheduleRepository by lazy {
        OfflineBusScheduleRepository(BusScheduleDatabase.getDatabase(context).busScheduleDao())
    }
}
