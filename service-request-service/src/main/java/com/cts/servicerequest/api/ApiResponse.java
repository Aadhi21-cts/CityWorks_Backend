package com.cts.servicerequest.api;

public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;

    private ApiResponse() {}

    public static <T> Builder<T> builder() { return new Builder<>(); }

    public String getStatus() { return status; }
    public String getMessage() { return message; }
    public T getData() { return data; }

    public static class Builder<T> {
        private final ApiResponse<T> r = new ApiResponse<>();
        public Builder<T> status(String s) { r.status = s; return this; }
        public Builder<T> message(String m) { r.message = m; return this; }
        public Builder<T> data(T d) { r.data = d; return this; }
        public ApiResponse<T> build() { return r; }
    }
}
