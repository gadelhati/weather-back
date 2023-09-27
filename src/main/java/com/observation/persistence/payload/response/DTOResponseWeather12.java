package com.observation.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseWeather12 {

    private UUID id;
    //SECTION 0

    //AABB
    private String mimi;
    private String mjmj;
    //YYGGiw
    private String yy;
    private String gg;
    private String iw;
    //IIiii
    private String ii;
    private String iii;

    //SECTION 1

    //iRiXhVV
    private String ir;
    private String ix;
    private String h;
    private String vv;
    //Nddff
    private String n;
    private String dd;
    private String ff;
    private String fff;//00fff, 00 - fixo
    //1snTTT
    private String sn1_1;
    private String ttt;
    //2snTdTdTd (ou 29UUU)
    private String sn2_1;
    private String tdtdtd;
    //3P0P0P0P0
    private String p0p0p0p0;
    //4PPPP
    private String pppp;
    //8NhCLCMCH
    private String nh;
    private String cl;
    private String cm;
    private String ch;

    //SECTION 3

    //333
    //1snTxTxTx
    private String sn1_3;
    private String txtxtx;
    //2snTnTnTn
    private String sn2_3;
    private String tntntn;
}