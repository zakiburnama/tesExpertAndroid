package com.example.faktaanime.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.faktaanime.R
import com.example.faktaanime.core.domain.model.Anime
import com.example.faktaanime.databinding.ActivityDetailTourismBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailTourismActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTourismViewModel: DetailTourismViewModel by viewModel()
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailTourism = intent.getParcelableExtra<Anime>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailAnime: Anime?) {
        detailAnime?.let {
            supportActionBar?.title = detailAnime.name
//            binding.content.tvDetailDescription.text = detailAnime.description
            binding.content.tvDetailDescription.text = detailAnime.name
            Glide.with(this)
                .load(detailAnime.img)
                .into(binding.ivDetailImage)

            var statusFavorite = detailAnime.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailAnime, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
