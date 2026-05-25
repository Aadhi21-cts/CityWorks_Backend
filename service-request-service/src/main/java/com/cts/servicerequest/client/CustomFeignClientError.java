package com.cts.servicerequest.client;

import com.cts.servicerequest.exception.ResourceNotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomFeignClientError implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		switch(response.status()) {
			case 404:
				return new ResourceNotFoundException("Asset is not found");
			case 500:
				return new RuntimeException("Asset Service Internal Server Error");
			default:
				return new RuntimeException("Feign client error with status: "+response.status());
		}
	}

}
