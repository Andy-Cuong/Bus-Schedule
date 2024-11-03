package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineBusScheduleRepository(private val busScheduleDao: BusScheduleDao) : BusScheduleRepository {
    override fun getAllBusSchedulesFlow(): Flow<List<BusSchedule>> =
        busScheduleDao.getAllSchedules()


    override fun getBusScheduleFlowByStop(stopName: String): Flow<List<BusSchedule>> =
        busScheduleDao.getScheduleByStop(stopName)
}