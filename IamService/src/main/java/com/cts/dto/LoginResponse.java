package com.cts.dto;

public class LoginResponse {

    private String token;
    private String role;
    private Long userId;

    public LoginResponse(String token, String role, Long userId) {
        this.token = token;
        this.role = role;
        this.userId = userId;    }

    public Long getUserId() {
		return userId;
	}

	public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }
}
