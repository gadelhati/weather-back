package br.eti.observation.persistence.payload.request;

import java.util.UUID;

public class DTORequestLogOut {
  private UUID userId;

  public UUID getUserId() {
    return this.userId;
  }
}