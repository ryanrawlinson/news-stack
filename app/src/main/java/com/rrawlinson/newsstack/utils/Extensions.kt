package com.rrawlinson.newsstack.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutResource: Int): View =
        LayoutInflater.from(context).inflate(layoutResource, this, false)