package com.bitespeed.backendassignment.helpers;

import lombok.Data;

@Data
public class ResponseUtil {
	
	private int status;
	
    private String message;
    
    public ResponseUtil(int status, String message) {
    	
    	this.status = status;
        this.message = message;
    }
    
}
