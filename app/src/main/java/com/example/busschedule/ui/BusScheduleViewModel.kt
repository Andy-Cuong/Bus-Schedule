/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.BusScheduleApplication
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusScheduleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn

class BusScheduleViewModel(
    private val busScheduleRepository: BusScheduleRepository
): ViewModel() {

    // Get full bus schedule
    fun getFullSchedule(): /*State*/Flow<List<BusSchedule>> =
        busScheduleRepository.getAllBusSchedulesFlow()
//            .filterNotNull()
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = TIMEOUT_MILLIS),
//                initialValue = listOf()
//            )

    // Get  bus schedule by stop
    fun getScheduleFor(stopName: String): /*State*/Flow<List<BusSchedule>> =
        busScheduleRepository.getBusScheduleFlowByStop(stopName = stopName)
//            .filterNotNull()
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = TIMEOUT_MILLIS),
//                initialValue = listOf()
//            )

    companion object {
        const val TIMEOUT_MILLIS = 5000L

        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as BusScheduleApplication
                val busScheduleRepository = application.container.busScheduleRepository
                BusScheduleViewModel(busScheduleRepository = busScheduleRepository)
            }
        }
    }
}
