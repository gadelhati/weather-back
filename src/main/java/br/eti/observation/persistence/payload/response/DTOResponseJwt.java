package br.eti.observation.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseJwt {

	private String accessToken;
	private String refreshToken;
	private UUID id;
	private String username;
	private String email;
	private List<String> roles;
}