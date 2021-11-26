package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.validation.NotFoundException
import com.utflnx.who.knows.backend.validation.UnauthorizedException
import javax.validation.ConstraintViolationException

interface IErrorController {
    fun handleValidation(exception: ConstraintViolationException): WebResponse<String>
    fun handleNotFound(exception: NotFoundException): WebResponse<String>
    fun handleUnauthorized(exception: UnauthorizedException): WebResponse<String>
}