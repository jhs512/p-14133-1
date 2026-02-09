package com.back

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.Transactional

@Configuration
class NotProdInitData(
    private val postService: PostService,
) {
    @Bean
    fun notProdInitDataApplicationRunner(): ApplicationRunner =
        @Transactional
        ApplicationRunner {
            if (postService.count() > 0) return@ApplicationRunner

            postService.write("user1")
            postService.write("user2")
            postService.write("user3")
        }
}