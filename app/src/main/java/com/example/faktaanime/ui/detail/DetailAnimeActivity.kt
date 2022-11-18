package com.example.faktaanime.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.faktaanime.R
import com.example.faktaanime.core.domain.model.Anime
import com.example.faktaanime.databinding.ActivityDetailAnimeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailAnimeActivity : AppCompatActivity() {

    private val detailAnimeViewModel: DetailAnimeViewModel by viewModel()
    private lateinit var binding: ActivityDetailAnimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailAnime = intent.getParcelableExtra<Anime>(EXTRA_DATA)
        showDetailAnime(detailAnime)
    }

    private fun showDetailAnime(detailAnime: Anime?) {
        detailAnime?.let {
            supportActionBar?.title = detailAnime.name
            binding.content.tvDetailDescription.text = detailAnime.name
            Glide.with(this)
                .load(detailAnime.img)
                .into(binding.ivDetailImage)

            var statusFavorite = detailAnime.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailAnimeViewModel.setFavoriteAnime(detailAnime, statusFavorite)
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

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
