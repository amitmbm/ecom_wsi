package com.wsi.common;

import com.wsi.dto.ErrorsDTO;

public class Utility {

	public static ErrorsDTO createError(ErrorConstants errorConstants, String internalMessage){
		ErrorsDTO errorsDTO  = new ErrorsDTO();
		errorsDTO.setCode(errorConstants.getCode());
		errorsDTO.setInternalMessage(internalMessage);
		errorsDTO.setMoreInfo("link with error code will come here");
		errorsDTO.setUserMessage(errorConstants.getMessage());
		return errorsDTO;
	}
}
