package br.eti.observation.persistence.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumFormat {
    ESFERICO("esférico"),
    PILAR("pilar"),
    CHARUTO("charuto");

    private final String nome;
}