package com.example.faktaanime.maps

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.faktaanime.core.data.Resource
import com.example.faktaanime.maps.databinding.ActivityNewsBinding
import com.example.faktaanime.maps.di.newsModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class NewsActivity : AppCompatActivity() {

    private val newsViewModel: NewsViewModel by viewModel()
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(newsModule)

        supportActionBar?.title = "Anime News"

        getAnimeData()
    }

    private fun getAnimeData() {
        newsViewModel.anime.observe(this, { anime ->
            if (anime != null) {
                when (anime) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvNews.text = "This is news of ${anime.data?.get(0)?.name}"
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