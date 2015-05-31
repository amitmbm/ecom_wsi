package com.wsi.common;

import org.json.JSONObject;

/**
 * @author Amit Khandelwal
 * This class is useful to set the REST opartions reult .
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class OperationResult<T> extends JSONObject {

	private T payload;
	private OperationResultState operationResultState;
	

	public OperationResult() {
		
	}
	public  OperationResult(T payload , OperationResultState resultState) {
		this.payload = payload;
		this.operationResultState = resultState;
	}
	
	public  OperationResult(T payload , OperationResultState resultState, String nextStepType) {
		this.payload = payload;
		this.operationResultState = resultState;
	}


	public T getPayload() {
		return payload;
	}


	public void setPayload(T payload) {
		this.payload = payload;
	}


	public OperationResultState getOperationResultState() {
		return operationResultState;
	}


	public void setOperationResultState(OperationResultState operationResultState) {
		this.operationResultState = operationResultState;
	}

	public void setInfo(String heading , String detailedMessage) {
		this.getOperationResultState().setHeading(heading);
		this.getOperationResultState().setDetailedMessage(detailedMessage);
	}
	
	public void setInfo(String heading , String detailedMessage , String newService) {
        this.getOperationResultState().setHeading(heading);
        this.getOperationResultState().setDetailedMessage(detailedMessage);
        this.getOperationResultState().setNewFLag(newService);
    }
	
}
