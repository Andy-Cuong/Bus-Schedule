package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusScheduleRepository {
    fun getAllBusSchedulesFlow(): Flow<List<BusSchedule>>

    fun getBusScheduleFlowByStop(stopName: String): Flow<List<BusSchedule>>
}