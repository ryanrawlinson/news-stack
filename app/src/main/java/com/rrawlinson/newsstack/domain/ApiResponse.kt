package com.rrawlinson.newsstack.domain

abstract class ApiResponse(private val status: String = "", private val totalResults: Int = 0)