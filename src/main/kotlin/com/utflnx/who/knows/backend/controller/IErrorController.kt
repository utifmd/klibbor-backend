package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import javax.validation.ConstraintViolationException

interface IErrorController {
    fun handleValidation(exception: ConstraintViolationException): WebResponse<String>
}