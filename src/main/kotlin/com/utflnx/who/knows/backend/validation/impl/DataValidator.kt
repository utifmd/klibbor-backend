package com.utflnx.who.knows.backend.validation.impl

import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Component
class DataValidator(val validator: Validator): IDataValidator {
    override fun validate(any: Any) {
        val result = validator.validate(any)

        if (result.size != 0)
            throw ConstraintViolationException(result)
    }
}