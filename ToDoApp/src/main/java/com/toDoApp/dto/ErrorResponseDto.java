package com.toDoApp.dto;

public class ErrorResponseDto {
	private String apiUrl;
	private String errorCode;
	private String errorStatus;
	private String errorMessage;
	
	public ErrorResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponseDto(String apiUrl, String errorCode, String errorStatus, String errorMessage) {
		super();
		this.apiUrl = apiUrl;
		this.errorCode = errorCode;
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}
	

}
