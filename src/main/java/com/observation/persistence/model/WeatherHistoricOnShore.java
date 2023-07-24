package com.observation.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.Date;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class WeatherHistoricOnShore extends GenericEntity {

    //SECTION 0

    //AABB
    private String aabbxx;
    private String mimi;
    private String mjmj;
    private String estacao;
    //DDDDDDD

    private String ddddddd;
    //A1bwnbnbnb
    private String a1;
    private String bw;
    private String nbnbnb;
    //YYGGiw
    private String yy;
    private String gg;
    private String iw;
    //IIiii

    private String ii;

    private String iii;
    //99LaLaLa
    private String lalala;
    //QcLoLOLOLO
    private String qc;
    private String lolololo;

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
    private String fff;
    //1snTTT
    private String sn1_1;
    private String ttt;
    //2snTdTdTd (ou 29UUU)
    private String sn2_1;
    private String tdtdtd;
    private String uuu;
    //3P0P0P0P0
    private String p0p0p0p0;
    //4PPPP
    private String pppp;
    //4a3hhh
    private String a3;
    private String hhh;
    //5appp
    private String a;
    private String ppp;
    //6RRRtR
    private String rrr;
    private String tr;
    //7wwW1W2
    private String ww;
    private String w1w2;
    private String w1;
    private String w2;
    //7wawaWa1Wa2
    private String wawa;
    private String wa1;
    private String wa2;
    //8NhCLCMCH
    private String nh;
    private String cl;
    private String cm;
    private String ch;
    //9GGgg
    private String gggg;

    //SECTION 2

    //222DsVs
    private String ds;
    private String vs;
    //0SsTwTwTw
    private String ss;
    private String twtwtw;
    //1PwaPwaHwaHwa
    private String pwapwa;
    private String hwahwa;
    //2PwPwHwHw
    private String pwpw;
    private String hwhw;
    //3dw1dw1dw2dw2
    private String dw1dw1;
    private String dw2dw2;
    //4Pw1Pw1Hw1Hw1
    private String pw1pw1;
    private String hw1hw1;
    //5Pw2Pw2Hw2Hw2
    private String pw2pw2;
    private String hw2hw2;
    //6IsEsEsRs (ou ICING + lig. clara)
    private String is_ice;
    private String eses;
    private String rs;
    //70HwaHwaHwa
    private String hwahwahwa;
    //8swTbTbTb
    private String sw;
    private String tbtbtb;
    //ICE ciSibiDizi (ou ling. clara)
    private String ci;
    private String si;
    private String bi;
    private String di;
    private String zi;

    //SECTION 3

    //333
    //1snTxTxTx
    private String sn1_3;
    private String txtxtx;
    //2snTnTnTn
    private String sn2_3;
    private String tntntn;
    //58/9P24P24P24
    private String ind89;
    private String p24p24p24;

    //SECTION 5

    //555
    //chwicMcsicFicpicQ
    private String ichw;
    private String icm;
    private String cs;
    private String icf;
    private String icp;
    private String icq;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;

    private LocalDateTime dateObservation;
    private String observador;
    //    @Transient
    private String observerName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "stationHistoricOffShore")
    private StationHistoricOffShore stationHistoricOffShore;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "observer")
    private Observer observer;
}