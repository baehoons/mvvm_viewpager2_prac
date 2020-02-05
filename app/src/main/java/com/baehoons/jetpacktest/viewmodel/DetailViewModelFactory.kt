package com.baehoons.jetpacktest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baehoons.jetpacktest.data.GardenPlantingRepository
import com.baehoons.jetpacktest.data.PlantRepository

class DetailViewModelFactory (
    private val plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(plantRepository, gardenPlantingRepository, plantId) as T
    }
}
