package com.example.faktaanime.maps

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.faktaanime.core.data.Resource
import com.example.faktaanime.maps.databinding.ActivityMapsBinding
import com.example.faktaanime.maps.di.mapsModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {

    private val mapsViewModel: MapsViewModel by viewModel()
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(mapsModule)

        supportActionBar?.title = "Anime Map"

        getAnimeData()
    }

    private fun getAnimeData() {
        mapsViewModel.anime.observe(this, { anime ->
            if (anime != null) {
                when (anime) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "This is map of ${anime.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = anime.message
                    }
                }
            }
        })
    }
}