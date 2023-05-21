package com.observation.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumEquipment {
    ANEMOGRAFO("Anemógrafo"), //Registra continuamente a direção (em graus) e a velocidade instantânea do vento (em m/s), a distância total (em km) percorrida pelo vento com relação ao instrumento e as rajadas (em m/s).
    ANEMOMETRO("Anemômetro"), //Mede a velocidade do vento (em m/s) e, em alguns tipos, também a direção (em graus).
    BAROGRAFO("Barógrafo"), //Registra continuamente a pressão atmosférica em milímetros de mercúrio (mm Hg) ou em milibares (mb).
    BAROMETRO("Barômetro"), //Mede a pressão atmosférica em coluna de milímetros de mercúrio (mm Hg) e em hectopascal (hPa).
    CATAVENTO("Catavento"), //
    EVAPORIMETRO_DE_PINCHE("Evaporímetro de Piche"),
    HELIOGRAFO("Heliógrafo"), //Registra a insolação ou a duração do brilho solar, em horas e décimos.
    HIGROGRAFO("Higrógrafo"), //Registra a umidade do ar, em valores relativos, expressos em porcentagem (%).
    MICROBAROGRAFO("Microbarógrafo"), //Registra continuamente a pressão atmosférica - em milímetros de mercúrio (mm Hg) ou em hectopascal (hPa), numa escala maior que a do Barógrafo, registrando as menores variações de pressão, o que lhe confere maior precisão.
    PIRANOGRAFO("Piranógrafo"), //Registra continuamente as variações da intensidade da radiação solar global, em cal.cm­².mm­¹.
    PIRANOMETRO("Piranômetro"), //Mede a radiação solar global ou difusa, em cal.cm­².mm­¹.
    PLUVIOGRAFO("Pluviógrafo"), //Registra a quantidade de precipitação pluvial (chuva), em milímetros (mm).
    PLUVIOMETRO("Pluviômetro"), //Mede a quantidade de precipitação pluvial (chuva), em milímetros (mm).
    PSICROMETRO("Psicrômetro"), //Mede a umidade relativa do ar - de modo indireto - em porcentagem (%). Compõe-se de dois termômetros idênticos, um denominado termômetro de bulbo seco, e outro com o bulbo envolvido em gaze ou cadarço de algodão mantido constantemente molhado, denominado termômetro de bulbo úmido.
    TERMOGRAFO("Termógrafo"), //Registra a temperatura do ar, em graus Celsius (°C).
    TERMOHIGROGRAFO("Termohigrógrafo"), //Registra, simultaneamente, a temperatura (°C) e a umidade relativa do ar (%).
    TERMOMETRO_DE_MAXIMA_E_MINIMA("Termômetro de máxima e mínima"), //Indicam as temperaturas máxima e mínima do ar (°C), ocorridas no dia.
    TERMOMETRO_DE_SOLO("Termômetros de solo"); //Indicam as temperaturas do solo, a diversas profundidades, em graus Celsius (°C).

    private final String name;
}