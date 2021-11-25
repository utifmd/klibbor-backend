package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IUserController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.service.IUserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val service: IUserService): IUserController {

    @PostMapping(value = ["/api/user"], produces = ["application/json"], consumes = ["application/json"])
    override fun createUser(

        @RequestBody createRequest: CreateRequest ): WebResponse<Response>{
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}