package com.back


import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService
) {
    @Transactional(readOnly = true)
    @GetMapping
    fun getItems(): List<Post> {
        return postService.findAll()
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    fun getItem(@PathVariable id: Int): Post {
        return postService.findById(id)!!
    }
}