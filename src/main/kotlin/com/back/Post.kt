package com.back

import jakarta.persistence.*

@Entity
class Post(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var username: String,
    @field:Version
    var version: Int = 0,
)