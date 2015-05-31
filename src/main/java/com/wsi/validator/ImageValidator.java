package com.wsi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ImageValidator implements ConstraintValidator<ImageAnnotation, String> {

	private static Logger logger = Logger.getLogger(ImageValidator.class);

	@Override
	public void initialize(ImageAnnotation paramA) {
	}

	@Override
	public boolean isValid(String Image, ConstraintValidatorContext context) {

		try {
			if(Image ==null){
				return true;
			}
			byte[] imageDataBytes = Base64.decodeBase64(Image);
			int length = imageDataBytes.length;
			float size = length / 1024; // In Kilo Bytes
			if (size > 20) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						"Image size exceeds the maximum upload size !")
						.addConstraintViolation();
				return false;
			} else

				return true;
		} catch (Exception e) {
			logger.error("Exception occured !!!", e);

		}
		return false;

	}
}
