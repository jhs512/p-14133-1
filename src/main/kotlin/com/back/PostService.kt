package com.back

import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
) {
    fun count() = postRepository.count()

    fun write(username: String): Post {
        val post = Post(
            0,
            username,
        )

        return postRepository.save(post)
    }

    fun findById(id: Int): Post? =
        postRepository.findById(id)
            .orElse(null)

    fun findAll(): List<Post> = postRepository.findAll()

    fun findByUsername(username: String): Post? =
        postRepository.findByUsername(username)

    fun findWithShareLockById(id: Int): Post? =
        postRepository.findWithShareLockById(id)

    fun findWithWriteLockById(id: Int): Post? =
        postRepository.findWithWriteLockById(id)

    fun modifyOptimistic(id: Int): Post {
        val post = findById(id)

        Thread.sleep(3_0000)

        return post?.apply {
            username = "${username}!"
        } ?: throw NoSuchElementException("Post not found with id: $id")
    }
}