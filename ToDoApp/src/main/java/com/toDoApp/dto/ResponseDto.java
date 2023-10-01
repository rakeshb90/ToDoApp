package com.toDoApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
		name="Response of ToDo app",
	    description="Response having response code and response message"
	)
public class ResponseDto {
	@Schema(
		    description="Response code ",example="200"
		)
	private String responseCode;
	@Schema(
		    description="Response message ",example="Opreation done successfuly"
		)
	private String responseMsg;
	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseDto(String responseCode, String responseMsg) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	

}
