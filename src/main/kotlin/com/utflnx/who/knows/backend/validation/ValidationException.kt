package com.utflnx.who.knows.backend.validation


class DataNotFoundException(override val message: String): Exception()

class NotFoundException: Exception()

class UnauthorizedException: Exception()

class InvalidEmailException: Exception()

class DataExistException: Exception()

class InvalidPasswordException: Exception()

class InvalidMaxSizeException: Exception()