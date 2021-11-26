package com.utflnx.who.knows.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
// @ComponentScan(basePackageClasses = [UserController::class])
class WhoKnowsBackendApplication

fun main(args: Array<String>) {
	runApplication<WhoKnowsBackendApplication>(*args)
}
