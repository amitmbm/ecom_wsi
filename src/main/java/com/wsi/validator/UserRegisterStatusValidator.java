package com.wsi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.wsi.dto.UserProfileDTO;

@Component
public class UserRegisterStatusValidator implements
		ConstraintValidator<ValidUserRegisterStatus, UserProfileDTO> {


	@Override
	public void initialize(ValidUserRegisterStatus constraintAnnotation) {
	}

	@Override
	public boolean isValid(UserProfileDTO user, ConstraintValidatorContext context) {

		boolean userStatus = user.getIsRegister();
		if (userStatus|| !userStatus ) {
			System.out.println("in success callback");
			return true;
		}

		context.disableDefaultConstraintViolation();
		System.out.println("in failure callback");
		context.buildConstraintViolationWithTemplate(
				"User Status " + userStatus + " is invalid. It should be either of " +
				"true" + "or" + "false"+".")
				/*AuthServiceConstants.USER_STATUS_BLOCKED + "," +
				AuthServiceConstants.USER_STATUS_DISABLED + "," +
				AuthServiceConstants.USER_STATUS_PENDING + ".")*/
				.addConstraintViolation();
		return false;
	}

}
