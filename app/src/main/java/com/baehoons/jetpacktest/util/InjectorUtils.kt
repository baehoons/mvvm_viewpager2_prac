/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baehoons.jetpacktest.util

import android.content.Context
import androidx.fragment.app.Fragment
import com.baehoons.jetpacktest.data.AppDatabase
import com.baehoons.jetpacktest.data.GardenPlantingRepository
import com.baehoons.jetpacktest.data.PlantRepository
import com.baehoons.jetpacktest.viewmodel.DetailViewModelFactory
import com.baehoons.jetpacktest.viewmodel.ListViewModelFactory
import com.baehoons.jetpacktest.viewmodel.MainViewModelFactory


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(
                AppDatabase.getInstance(context.applicationContext).plantDao())
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
                AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
    }

    fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): MainViewModelFactory {
        val repository = getGardenPlantingRepository(context)
        return MainViewModelFactory(repository)
    }

    fun providePlantListViewModelFactory(fragment: Fragment): ListViewModelFactory {
        val repository = getPlantRepository(fragment.requireContext())
        return ListViewModelFactory(repository, fragment)
    }

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): DetailViewModelFactory {
        return DetailViewModelFactory(getPlantRepository(context),
                getGardenPlantingRepository(context), plantId)
    }
}
