package resource


import model.Article
import service.ArticleService
import java.lang.NullPointerException
import java.util.*
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.NotFoundException
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

class ArticlesResource(private val articleService: ArticleService) {

    @GET
    fun getArticles() : List<Article> {
        return this.articleService.getArticles()
    }


    @GET
    @Path("{id}")
    fun getArticle(@PathParam("id") id: Int): Article {
        return this.articleService.getArticle(id) ?: throw NotFoundException()
    }

    @PUT
    @Path("{id}")
    fun saveArticle(@Valid article: Article): Response {
        this.articleService.saveArticle(article);
        return Response.status(Response.Status.CREATED).build()
    }

    @DELETE
    @Path("{id}")
    fun deleteArticle(@PathParam("id") id: Int) {
        this.articleService.deleteArticle(id)
    }
}