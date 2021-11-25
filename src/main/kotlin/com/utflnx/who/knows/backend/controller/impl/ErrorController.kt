package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IErrorController
import com.utflnx.who.knows.backend.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController: IErrorController {

    @ExceptionHandler(value = [ ConstraintViolationException::class ])
    override fun handleValidation(exception: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = exception.message ?: "Violation Exception"
        )
    }
}