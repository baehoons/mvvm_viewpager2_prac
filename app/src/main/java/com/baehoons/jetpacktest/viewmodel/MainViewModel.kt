package com.baehoons.jetpacktest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.baehoons.jetpacktest.data.GardenPlantingRepository
import com.baehoons.jetpacktest.data.PlantAndGardenPlantings

class MainViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}