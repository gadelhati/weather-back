package com.observation.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumTypePlatform {
    NAVIO_DE_PESQUISA("Navio de Pesquisa"),
    NAVIO_NAO_ESPECIALIZADO("Navio Nao Especializado"),
    SATELITE("Satelite"),
    BALAO_METEOROLOGICO("Balao Meteorologico"),
    AERONAVE("Aeronave (Aviao, Helicoptero, ...)"),
    BOIA_DE_FUNDEIO("Boia de Fundeio"),
    BOIA_DE_DERIVA("Boia de Deriva"),
    FLUTUADOR_SUBMERSO_LIGADO_AO_FUNDO_POR_POITA("Flutuador Submerso Ligado ao Fundo por Poita"),
    FLUTUADOR_SUBMERSO_DE_DERIVA("Flutuador Submerso de Deriva"),
    PLATAFORMA_FIXA("Plataforma Fixa"),
    ESTACAO_COSTEIRA("Estacao costeira"),
    ICEBERG("Iceberg"),
    SUBMERSIVEL("Submersivel"),
    OUTROS("Outros"),
    PLATAFORMA_FLUTUANTE("Plataforma flutuante"),
    LANCHA("Lancha"),
    BARCO("Barco (Remo, vela, inflável, etc)"),
    MERGULHADOR("Mergulhador"),
    PARAQUEDAS("Paraquedas"),
    ESTAÇÃO("Estacao Submersa Fixa ao Fundo"),
    FLUTUADOR_SUBMERSO_LIGADO_AO_FUNDO("Estacao Terrestre Movel"),
    SUBMERSIVEL_NAO_ESPECIALIZADO("Submersivel Nao Especializado"),
    FOGUETE("Foguete");

    private final String name;
}
