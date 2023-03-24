package com.example.lecture_1a_7.domain.model

data class Note(
    val id: Int = 0,
    val title: String,
    val description: String,
    val createdAt: Long
)