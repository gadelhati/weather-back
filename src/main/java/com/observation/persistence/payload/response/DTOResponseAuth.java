package com.observation.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class DTOResponseAuth {

    private String accessToken;
    private String tokenType = "Bearer ";
    private List<String> roles;
}