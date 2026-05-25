package com.cts.servicerequest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenResponseDto {
	private Long userId;
    private String name;
    private String username;
    private String email;
    private String status;
    private String role;
}
