package com.baehoons.jetpacktest.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.baehoons.jetpacktest.data.GardenPlantingRepository
import com.baehoons.jetpacktest.data.PlantRepository

class ListViewModelFactory
    (private val repository: PlantRepository,
     owner: SavedStateRegistryOwner,
     defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return ListViewModel(repository, handle) as T
    }
}
