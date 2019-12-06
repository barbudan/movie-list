package com.example.movie_list.model.payloads

import com.example.movie_list.model.Movie

data class ChangePagePayload(val list: List<Movie>, val request: Boolean)