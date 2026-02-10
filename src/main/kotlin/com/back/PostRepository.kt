package com.back

import jakarta.persistence.LockModeType.PESSIMISTIC_READ
import jakarta.persistence.LockModeType.PESSIMISTIC_WRITE
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock

interface PostRepository : JpaRepository<Post, Int> {
    fun findByUsername(username: String): Post?

    @Lock(PESSIMISTIC_READ)
    fun findWithShareLockById(id: Int): Post?

    @Lock(PESSIMISTIC_WRITE)
    fun findWithWriteLockById(id: Int): Post?
}