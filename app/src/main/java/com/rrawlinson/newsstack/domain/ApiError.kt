package com.rrawlinson.newsstack.domain

data class ApiError(private val status: String, private val code: String, private val message: String)