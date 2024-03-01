package com.example.statisticsapi.validation;

import com.example.statisticsapi.dto.internal.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RepeatedPasswordValidator implements ConstraintValidator<FieldMatch,
        UserRegistrationRequestDto> {
    @Override
    public boolean isValid(UserRegistrationRequestDto user,
                           ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword() != null && user.getPassword().equals(user.getRepeatPassword());
    }
}
