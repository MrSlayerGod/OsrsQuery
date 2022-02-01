package com.query.cache.definitions.loader

import com.query.Application
import com.query.cache.definitions.provider.TextureDefinition
import com.query.cache.definitions.provider.TextureProvider
import java.util.concurrent.CountDownLatch

class TextureLoader(val latch: CountDownLatch?) : Runnable {

    override fun run() {
        val start: Long = System.currentTimeMillis()
        Application.store(TextureDefinition::class.java, TextureProvider().load().definitions)
        Application.prompt(TextureLoader::class.java, start)
        latch?.countDown()
    }

}