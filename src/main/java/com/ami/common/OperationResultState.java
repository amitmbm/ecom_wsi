/*package com.ami.common;

import org.json.JSONObject;


 * Author : Amit Khandelwal 
 * Thsi class is use to set the common peroperty , which every REST response will have.
 
public class OperationResultState extends JSONObject {

	private boolean success;
	private String heading;
	private String newFLag;
	private String detailedMessage;
	private String targetLocation;
	
	public OperationResultState(boolean isSuccess, String heading,
			String detailedMessage , String targetLocation) {
		this.success = isSuccess;
		this.heading = heading;
		this.setTargetLocation(targetLocation);
		this.detailedMessage = detailedMessage;
	}
	
	public OperationResultState() {
		
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean isSuccess) {
		this.success = isSuccess;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDetailedMessage() {
		return detailedMessage;
	}

	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

	public String getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(String targetLocation) {
		this.targetLocation = targetLocation;
	}

    public String getNewFLag() {
        return newFLag;
    }

    public void setNewFLag(String newFLag) {
        this.newFLag = newFLag;
    }
}
*/