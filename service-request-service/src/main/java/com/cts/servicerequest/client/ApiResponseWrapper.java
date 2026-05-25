package com.cts.servicerequest.client;

/**
 * Mirrors the ApiResponse<T> shape returned by citizen-service
 * so Feign can deserialize it correctly.
 */
public class ApiResponseWrapper<T> {
    private String status;
    private String message;
    private T data;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
