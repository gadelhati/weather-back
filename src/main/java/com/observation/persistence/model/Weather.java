package com.observation.persistence.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.Date;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Weather extends GenericEntity {

    //SECTION 0

    //AABB
    private String aabbxx;
    private String miMi;
    private String mjMj;
    private String estacao;
    //DDDDDDD
    private String ddddddd;
    //A1bwnbnbnb
    private String a1;
    private String bw;
    private String nbNbNb;
    //YYGGiw
    private String yy;
    private String gg;
    private String iw;
    //IIiii
    private String ii;
    private String iii;
    //99LaLaLa
    private String laLaLa;
    //QcLoLOLOLO
    private String qc;
    private String loLoLoLo;

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
    private String tdTdTd;
    //3P0P0P0P0
    private String poPoPoPo;//p0p0p0p0
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
    private String w1W2;
    private String w1;
    private String w2;
    //7wawaWa1Wa2
    private String waWa;
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
    private String twTwTw;
    //1PwaPwaHwaHwa
    private String pwaPwa;
    private String hwaHwa;
    //2PwPwHwHw
    private String pwPw;
    private String hwHw;
    //3dw1dw1dw2dw2
    private String dw1Dw1;
    private String dw2Dw2;
    //4Pw1Pw1Hw1Hw1
    private String pw1Pw1;
    private String hw1Hw1;
    //5Pw2Pw2Hw2Hw2
    private String pw2Pw2;
    private String hw2Hw2;
    //6IsEsEsRs (ou ICING + lig. clara)
    private String is_ice;
    private String eses;
    private String rs;
    //70HwaHwaHwa
    private String hwaHwaHwa;
    //8swTbTbTb
    private String sw;
    private String tbTbTb;
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
    private String txTxTx;
    //2snTnTnTn
    private String sn2_3;
    private String tnTnTn;
    //58/9P24P24P24
    private String ind89;
    private String p24P24P24;

    //SECTION 5

    //555
    //chwicMcsicFicpicQ
    private String iChw;
    private String iCm;
    private String cs;
    private String iCf;
    private String iCp;
    private String iCq;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    private LocalDateTime dateObservation;
    private String observador;
    //    @Transient
    private String observerName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "station")
    private Station station;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "observer")
    private Observer observer;
}