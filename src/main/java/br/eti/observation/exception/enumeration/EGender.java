package br.eti.observation.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EGender {
    MALE("Male"),
    FEMALE("Female");

    String gender;
}