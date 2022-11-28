package kr.co.cotton.myapplication.sportsnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.cotton.myapplication.data.SportsNews
import kr.co.cotton.myapplication.databinding.ItemSportsNewsBinding

class SportsNewsItemAdapter :
    ListAdapter<SportsNewsItem, SportsNewsItemAdapter.SportsNewsViewHolder>(
        SportsNewsItem.diffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsNewsViewHolder {
        val binding =
            ItemSportsNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SportsNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SportsNewsViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class SportsNewsViewHolder(
        private val binding: ItemSportsNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sportsNewsItem: SportsNewsItem) {
            binding.item = sportsNewsItem
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItem(
            sportsNewsList: List<SportsNews>?
        ) {
            sportsNewsList?.let {
                val items = sportsNewsList.map { sportsNews -> SportsNewsItem(sportsNews) }
                (adapter as SportsNewsItemAdapter).submitList(items)
            }
        }
    }
}