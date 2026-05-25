package com.cts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
 
    private Long userId;
    private String name;
    private String username;
    private String email;
    private String role;
    private String status;
}
