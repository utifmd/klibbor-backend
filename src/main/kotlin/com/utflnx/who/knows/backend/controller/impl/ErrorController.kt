package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IErrorController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.validation.InvalidEmailException
import com.utflnx.who.knows.backend.validation.InvalidPasswordException
import com.utflnx.who.knows.backend.validation.NotFoundException
import com.utflnx.who.knows.backend.validation.UnauthorizedException
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

    @ExceptionHandler(value = [ NotFoundException::class ])
    override fun handleNotFound(exception: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = exception.message ?: "Not Found Exception"
        )
    }

    @ExceptionHandler(value = [ UnauthorizedException::class ])
    override fun handleUnauthorized(exception: UnauthorizedException): WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "UNAUTHORIZED",
            data = exception.message ?: "Unauthorized Exception"
        )
    }

    @ExceptionHandler(value = [ InvalidEmailException::class ])
    override fun handleInvalidEmail(exception: InvalidEmailException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = exception.message ?: "User does not exist."
        )
    }

    @ExceptionHandler(value = [ InvalidPasswordException::class ])
    override fun handleInvalidPassword(exception: InvalidPasswordException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = exception.message ?: "Password mismatch."
        )
    }
}