package kr.co.cotton.myapplication.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.co.cotton.myapplication.data.SportsNews
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object RemoteSportsNewsDataSource : SportsNewsDataSource {

    override fun getMainSportsNews(): Flow<List<SportsNews>> = flow {
        try {
            val sportsNewsUrl = "https://sports.news.naver.com"
            val doc = Jsoup.connect(sportsNewsUrl).get()
            val sportsNewsList = getSportsNewsWithDoc(doc)

            emit(sportsNewsList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO)

    private fun getSportsNewsWithDoc(document: Document): List<SportsNews> {
        val newsList = mutableListOf<SportsNews>()
        val newsListDoc = document.select("li.today_item")

        repeat(newsListDoc.size) {
            newsListDoc[it].also { element ->
                val href = element.select("a").attr("href")
                val textArea = element.select("div.text_area")
                val imageArea = element.select("div.image_area")

                val title = textArea.select("strong.title").text()
                val imgSrc = imageArea.select("img").attr("src")
                val description = textArea.select("p.news").text()
                val sportsType = textArea.select("div.information span").first()?.text()
                val channel = textArea.select("div.information span").last()?.text()

                newsList.add(
                    SportsNews(
                        href = href,
                        title = title,
                        imgUrl = imgSrc,
                        description = description,
                        sportsType = sportsType,
                        channel = channel
                    )
                )
            }
        }

        return newsList.toList()
    }
}
