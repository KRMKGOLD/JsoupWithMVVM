package kr.co.cotton.myapplication

import androidx.recyclerview.widget.DiffUtil

data class SportsNewsItem(
    private val sportsNews: SportsNews
) {

    val href: String = sportsNews.href.orEmpty()

    val title: String = sportsNews.title.orEmpty()

    val imgUrl: String = sportsNews.imgUrl.orEmpty()

    val description: String = sportsNews.description.orEmpty()

    val sportsType: String = sportsNews.sportsType.orEmpty()

    val channel: String = sportsNews.channel.orEmpty()

    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<SportsNewsItem>() {
            override fun areItemsTheSame(
                oldItem: SportsNewsItem,
                newItem: SportsNewsItem
            ): Boolean {
                return oldItem.href == newItem.href
            }

            override fun areContentsTheSame(
                oldItem: SportsNewsItem,
                newItem: SportsNewsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
