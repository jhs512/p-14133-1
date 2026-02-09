package com.back

import jakarta.persistence.LockModeType.PESSIMISTIC_READ
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock

interface PostRepository : JpaRepository<Post, Int> {
    fun findByUsername(username: String): Post?

    @Lock(PESSIMISTIC_READ)
    fun findWithShareLockById(id: Int): Post?
}