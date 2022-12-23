package model

import org.joda.time.DateTime

data class Article(
    val id: Int,
    val header: String,
    val shortDescription: String,
    val text: String,
    val publish: DateTime = DateTime.now(),
    val authors: List<String>,
    val keywords: List<String>
)
