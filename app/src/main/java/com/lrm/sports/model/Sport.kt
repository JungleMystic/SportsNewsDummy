package com.lrm.sports.model

import com.lrm.sports.R

data class Sport(
    val id: Int,
    val titleResourceId: Int,
    val subTitleResourceId: Int,
    val imageResourceId: Int,
    val sportsImageBanner: Int,
    val newsDetails: Int = R.string.sports_news_detail_text
)
