package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IUserController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.service.IUserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val service: IUserService): IUserController {

    @PostMapping(value = ["/api/users"], produces = ["application/json"], consumes = ["application/json"])
    override fun createUser(
        @RequestBody createRequest: CreateRequest): WebResponse<Response.Complete> {
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
    @GetMapping(value = ["/api/users/{userId}"], produces = ["application/json"])
    override fun readUser(
        @PathVariable("userId") readRequest: String): WebResponse<Response.Complete> {
        val response = service.read(readRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
    @GetMapping(value = ["/api/users/count/{username}"], produces = ["application/json"])
    override fun count(
        @PathVariable("username") username: String): WebResponse<Int> {
        val count = service.count(username)
        return WebResponse(
            code = 200,
            status = "OK",
            data = count
        )
    }

    @PutMapping(value = ["/api/users/{userId}"], produces = ["application/json"], consumes = ["application/json"])
    override fun updateUser(
        @PathVariable("userId") id: String,
        @RequestBody updateRequest: UpdateRequest): WebResponse<Response.Complete> {
        val response = service.update(id, updateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(value = ["/api/users/{userId}"], produces = ["application/json"])
    override fun deleteUser(
        @PathVariable("userId") id: String): WebResponse<String> {
        service.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(value = [ "/api/users" ], produces = ["application/json"])
    override fun listUser(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int): WebResponse<List<Response.Complete>> {
        val users = service.list(ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = users
        )
    }

    @GetMapping(value = [ "/api/users/most-active" ], produces = ["application/json"])
    override fun activelyParticipants(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int): WebResponse<List<Response.Censored>> {
        val users = service.activelyParticipants(ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = users
        )
    }

    @GetMapping(value = ["/api/users/search/{nameOrUsername}"], produces = ["application/json"])
    override fun searchUser(
        @PathVariable("nameOrUsername") nameOrUsername: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "5") size: Int): WebResponse<List<Response.Censored>> {
        val users = service.search(nameOrUsername, ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = users
        )
    }

    @PostMapping(value = ["/api/auth/sign-in"], produces = ["application/json"], consumes = ["application/json"])
    override fun signInUser(
        @RequestBody loginRequest: LoginRequest): WebResponse<Response.Complete> {
        val response = service.signIn(loginRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}