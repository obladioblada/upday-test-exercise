import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import resource.ArticlesResource
import service.ArticleService

class App: Application<AppConfig>() {
    companion object {
        @JvmStatic fun main(args: Array<String>) = App().run(*args)
    }

    override fun run(myAppConfig: AppConfig, environment: Environment) {
        environment.objectMapper.registerModule(KotlinModule())
        val articleService = ArticleService()
        environment.jersey().register(ArticlesResource(articleService))
    }
}

