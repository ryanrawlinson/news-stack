package com.rrawlinson.newsstack.domain

data class HeadlineResponse(
        val source: Source?,
        val author: String?,
        val title: String?,
        val description: String?,
        val url: String?,
        val urlToImage: String?,
        val publishedAt: String?
)

class Source(val id: String?, val name: String?)

