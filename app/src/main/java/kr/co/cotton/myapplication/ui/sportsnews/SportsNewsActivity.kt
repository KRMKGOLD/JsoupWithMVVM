package kr.co.cotton.myapplication.ui.sportsnews

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.cotton.myapplication.R
import kr.co.cotton.myapplication.base.BaseActivity
import kr.co.cotton.myapplication.databinding.ActivitySportsNewsBinding

@AndroidEntryPoint
class SportsNewsActivity : BaseActivity<ActivitySportsNewsBinding>(
    R.layout.activity_sports_news
) {

    private val viewModel: SportsNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        binding.rvSportsNews.adapter = SportsNewsItemAdapter()
    }
}