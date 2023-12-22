package com.mpip.labs.lab_fragments.model

import java.io.Serializable

data class Movie(
    val id: String,
    val name: String,
    val description: String,
    val director: String,
    val actors: List<String>
) : Serializable