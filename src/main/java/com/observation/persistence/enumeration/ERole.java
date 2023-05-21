package com.observation.persistence.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum ERole {
  ROLE_USER("user"),
  ROLE_MODERATOR("moderator"),
  ROLE_ADMIN("admin"),
  ROLE_RECTIFIER("rectifier"),
  ROLE_OPERATOR("operator");

  private final String name;
}