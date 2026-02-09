package com.back

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Int> {
    fun findByUsername(username: String): Post?
}