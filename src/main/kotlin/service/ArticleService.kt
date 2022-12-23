package service

import com.google.common.collect.ImmutableList
import com.google.common.collect.Maps
import javassist.NotFoundException
import model.Article
import org.joda.time.DateTime

class ArticleService {

    private val articles: MutableMap<Int, Article> = mutableMapOf(
        1 to Article(1, "Article 1", "Description article 1 ", "text article 1",
            DateTime(),listOf("Author1", "Author2"), listOf("first")
        ),
        2 to Article(2,"Article 2", "Description article 2 ", "text article 2",
            DateTime(), listOf("Author2"), listOf("first")
        ),
        3 to Article(3,"Article 2", "Description article 2 ", "text article 2",
            DateTime(), listOf("Author2"), listOf("first")
        )
    )


    fun getArticles() : List<Article> {
        return this.articles.entries.map {(k,v) -> v}
    }

    fun saveArticle(article: Article) {
        this.articles[article.id] = article
    }

    fun getArticle(id: Int): Article? {
         return this.articles[id]
    }

    fun deleteArticle(id: Int) {
        this.articles.remove(id) ?: throw NotFoundException("Article with ID $id not found")
    }

}