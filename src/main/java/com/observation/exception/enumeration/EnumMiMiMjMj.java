package com.observation.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumMiMiMjMj {
    SYNOP("AAXX"),
    SHIP("BBXX"),
    HYDRA("HHXX"),
    WAVEOB("MMXX"),
    TRACKOB("NNXX"),
    SYNOP_MOBIL("OOXX"),
    ROCOB("SSXX"),
//    BATHY("?"),//PÁGINA 331, https://library.wmo.int/doc_num.php?explnum_id=10235
//    TESAC("?"),
    SARAD("WWXX"),
    SATOB("YYXX"),
    BUOY("ZZYY");

    private final String MiMiMjMj;
}