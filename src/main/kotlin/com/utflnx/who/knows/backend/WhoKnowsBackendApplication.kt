package com.utflnx.who.knows.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication // @ComponentScan(basePackageClasses = [UserController::class])
class WhoKnowsBackendApplication

fun main(args: Array<String>) {
	runApplication<WhoKnowsBackendApplication>(*args)
}
