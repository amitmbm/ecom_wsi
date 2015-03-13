package com.ami.jersey.providers;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.ami.common.ErrorConstants;
import com.ami.common.Utility;
import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.dto.ErrorsDTO;
import com.ami.enums.LogLevel;

@Component
@Provider
public class ValidationExceptionMapper implements
		ExceptionMapper<ValidationException> {

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			ValidationExceptionMapper.class.getName());

	@Override
	public Response toResponse(ValidationException e) {
		logger.logException(LogLevel.ERROR,
				"exception occured while posting a request", e);

		ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.BAD_REQUEST,e.getMessage());

		Response response = Response.status(Response.Status.BAD_REQUEST).entity(errorsDTO).build();
		return response;
	}

}
