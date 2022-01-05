package com.utflnx.who.knows.backend.service.config

import com.utflnx.who.knows.backend.repository.IApiKeyRepository
import com.utflnx.who.knows.backend.validation.UnauthorizedException
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(
    private val repository: IApiKeyRepository): WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {

        val url = (request as ServletWebRequest).request.requestURL
        val isFiles = url.contains("files/")

//        println(files)
//        println(isFiles)

        if (!isFiles){
            val xApiKey = request.getHeader("X-Api-Key") ?: throw UnauthorizedException()

            if (!repository.existsById(xApiKey))
                throw UnauthorizedException()
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) { }

    override fun afterCompletion(request: WebRequest, ex: Exception?) { }
}