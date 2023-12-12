package com.observation.persistence.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.observation.exception.annotation.UniqueWeather;
import com.observation.exception.annotation.weather.*;
import com.observation.persistence.model.Observer;
import com.observation.persistence.model.Station;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true)// @OnOrOffShore
@ValidNhCLCM @ValidTTTTdTdTd @ValidAppp @ValidCLCM @ValidCMCH
@ValidNCLCMCH
//@ValidNCLCMCHh
@ValidNddff @ValidNh @ValidNhCLCMCHh @ValidNhCLCMh @ValidNNh
@ValidNW2 @ValidTTTTnTnTn @ValidTTT
@ValidTxTxTx
@ValidVVh @ValidVVWW @ValidW1W2
@UniqueWeather @NameNotNull @DateNotNull
public class DTORequestWeather {

    private UUID id;
    //SECTION 0

    //AABB
    private String aabbxx;
    @Pattern(regexp = "AA||BB", message = "{mimi.valid}")
    private String miMi;
    @Pattern(regexp = "XX", message = "{mjmj.valid}")
    private String mjMj;
    //DDDDDDD
    private String estacao;
    //    @NotNull(message = "{ddddddd.not.null}") @NotBlank(message = "{ddddddd.not.blank}")
    private String ddddddd;
    //A1bwnbnbnb

    private String a1;

    private String bw;

    private String nbNbNb;
    //YYGGiw
    @Pattern(regexp = "[0-2][0-9]||3[0-1]", message = "{yy.valid}") @NotNull(message = "{yy.not.null}") @NotBlank(message = "{yy.not.blank}")
    private String yy;
    @Pattern(regexp = "00||03||06||09||12||15||18||21", message = "{gg.valid}") @NotNull(message = "{gg.not.null}") @NotBlank(message = "{gg.not.blank}")
    private String gg;
    @Pattern(regexp = "0||1||2||3||4", message = "{iw.valid}") @NotNull(message = "{iw.not.null}") @NotBlank(message = "{iw.not.blank}")
    private String iw;
    //IIiii
    @Pattern(regexp = "82||83", message = "{ii.valid}")
    private String ii;
    //    @Pattern(regexp = "[0-9][0-9][0-9]", message = "{iii.valid}")
    private String iii;
    //99LaLaLa
    @Pattern(regexp = "[0-8][0-9][0-9]||900", message = "{lalala.valid}")
    private String laLaLa;
    //QcLoLOLOLO
    @Pattern(regexp = "1||3||5||7", message = "{qc.valid}")
    private String qc;
    @Pattern(regexp = "[0-1][0-7][0-9][0-9]||1800", message = "{lolololo.valid}")
    private String loLoLoLo;

    //SECTION 1

    //iRiXhVV
    @Pattern(regexp = "1||3||4", message = "{ir.valid}") @NotNull(message = "{ir.not.null}") @NotBlank(message = "{ir.not.blank}")
    private String ir;
    @Pattern(regexp = "[1-7]", message = "{ix.valid}") @NotNull(message = "{ix.not.null}") @NotBlank(message = "{ix.not.blank}")
    private String ix;
    @Pattern(regexp = "[0-9]||\\/", message = "{h.valid}") @NotNull(message = "{h.not.null}") @NotBlank(message = "{h.not.blank}")
    private String h;
    @Pattern(regexp = "9[0-9]", message = "{vv.valid}") @NotNull(message = "{vv.not.null}") @NotBlank(message = "{vv.not.blank}")
    private String vv;
    //Nddff
    @Pattern(regexp = "[0-8]||\\/", message = "{n.valid}") @NotNull(message = "{n.not.null}") @NotBlank(message = "{n.not.blank}")
    private String n;
    @Pattern(regexp = "[0-2][0-9]||3[0-6]||99||\\/\\/", message = "{dd.valid}") @NotNull(message = "{dd.not.null}") @NotBlank(message = "{dd.not.blank}")
    private String dd;
    @Pattern(regexp = "[0-9][0-9]||\\/\\/", message = "{ff.valid}") @NotNull(message = "{ff.not.null}") @NotBlank(message = "{ff.not.blank}")
    private String ff;
    //@Pattern(regexp = "[1-9][0-9][0-9]", message = "{fff.valid}")
    private String fff;
    //1snTTT
    @Pattern(regexp = "[0-1]", message = "{sn1_1.valid}") @NotNull(message = "{sn1_1.not.null}") @NotBlank(message = "{sn1_1.not.blank}")
    private String sn1_1;
    @Pattern(regexp = "[0-4][0-9][0-9]||500||\\/\\/\\/", message = "{ttt.valid}") @NotNull(message = "{ttt.not.null}") @NotBlank(message = "{ttt.not.blank}")
    private String ttt;
    //2snTdTdTd (ou 29UUU)
    @Pattern(regexp = "0||1||9", message = "{sn2_1.valid}")
    private String sn2_1;
    @Pattern(regexp = "[0-4][0-9][0-9]||500||\\/\\/\\/", message = "{tdtdtd.valid}") @JsonProperty("tdTdTd_UUU")
    private String tdTdTd;
    //3P0P0P0P0
    @Pattern(regexp = "0[0-9][0-9][0-9]||1000||8[7-9][0-9][0-9]||9[0-9][0-9][0-9]", message = "{p0p0p0p0.valid}")
    private String poPoPoPo;//p0P0P0P0
    //4PPPP
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]||[0-9][0-9][0-9][0-9||\\/]", message = "{pppp.valid}") @NotNull(message = "{pppp.not.null}") @NotBlank(message = "{pppp.not.blank}")
    private String pppp;
    //4a3hhh
    @Pattern(regexp = "1||2||5||7||8", message = "{a3.valid}")
    private String a3;

    private String hhh;
    //5appp
    @Pattern(regexp = "[0-8]||\\/", message = "{a.valid}")
    private String a;
    @Pattern(regexp = "[0-1][0-9][0-9]||200||\\/||\\/||\\/", message = "{ppp.valid}")
    private String ppp;
    //6RRRtR
    @Pattern(regexp = "[0-9][0-9][0-9]||\\/\\/\\/||''", message = "{rrr.valid}")
    private String rrr;
    @Pattern(regexp = "[0-9]||''", message = "{tr.valid}")
    private String tr;
    //7wwW1W2
    @Pattern(regexp = "[0-9][0-9]", message = "{ww.valid}") @NotNull(message = "{ww.not.null}") @NotBlank(message = "{ww.not.blank}")
    private String ww;
    @Pattern(regexp = "[0-9][0-9]||\\/\\/||[0-9]\\/||\\/[0-9]", message = "{w1w2.valid}") @NotNull @NotBlank
    private String w1W2;
    //    @Pattern(regexp = "[0-9]||\\/", message = "{w1.valid}") @NotNull @NotBlank
//    private String w1;
//    @Pattern(regexp = "[0-9]||\\/", message = "{w2.valid}") @NotNull @NotBlank
//    private String w2;
    //7wawaWa1Wa2
    //@Pattern(regexp = "[0-9][0-9]", message = "{wawa.valid}")
    private String waWa;
    @Pattern(regexp = "[0-9]||\\/", message = "{wa1.valid}")
    private String wa1;
    @Pattern(regexp = "[0-9]||\\/", message = "{wa2.valid}")
    private String wa2;
    //8NhCLCMCH
    @Pattern(regexp = "[0-8]||\\/", message = "{nh.valid}")
    private String nh;
    @Pattern(regexp = "[0-9]||\\/", message = "{cl.valid}")
    private String cl;
    @Pattern(regexp = "[0-9]||\\/", message = "{cm.valid}")
    private String cm;
    @Pattern(regexp = "[0-9]||\\/", message = "{ch.valid}")
    private String ch;
    //9GGgg
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]||''", message = "{gggg.valid}")//HHmm
    private String gggg;

    //SECTION 2

    //222DsVs
    @Pattern(regexp = "[0-9]||\\/||''", message = "{ds.valid}")
    private String ds;
    @Pattern(regexp = "[0-9]||\\/||''", message = "{vs.valid}")
    private String vs;
    //0SsTwTwTw
    @Pattern(regexp = "[0-7]||''", message = "{ss.valid}")
    private String ss;
    @Pattern(regexp = "[0-3][0-9][0-9]||400||''", message = "{twtwtw.valid}")
    private String twTwTw;
    //1PwaPwaHwaHwa
    @Pattern(regexp = "[0-2][0-9]||30||\\/\\/||''", message = "{pwapwa.valid}")
    private String pwaPwa;
    @Pattern(regexp = "0[0-9]||10||\\/\\/||''", message = "{hwahwa.valid}")
    private String hwaHwa;
    //2PwPwHwHw
    @Pattern(regexp = "[0-1][0-9]||20||99||\\/\\/||''", message = "{pwpw.valid}")
    private String pwPw;
    @Pattern(regexp = "[0-2][0-9]||30||\\/\\/||''", message = "{hwhw.valid}")
    private String hwHw;
    //3dw1dw1dw2dw2
    @Pattern(regexp = "[0-2][0-9]||3[0-6]||''", message = "{dw1dw1.valid}")
    private String dw1Dw1;
    @Pattern(regexp = "[0-2][0-9]||3[0-6]||''", message = "{dw2dw2.valid}")
    private String dw2Dw2;
    //4Pw1Pw1Hw1Hw1
    @Pattern(regexp = "[0-2][0-9]||30||''", message = "{pw1pw1.valid}")
    private String pw1Pw1;
    @Pattern(regexp = "[0-2][0-9]||30||''", message = "{hw1hw1.valid}")
    private String hw1Hw1;
    //5Pw2Pw2Hw2Hw2
    @Pattern(regexp = "[0-2][0-9]||30||''", message = "{pw2pw2.valid}")
    private String pw2Pw2;
    @Pattern(regexp = "[0-2][0-9]||30||''", message = "{hw2hw2.valid}")
    private String hw2Hw2;
    //6IsEsEsRs (ou ICING + lig. clara)
    @Pattern(regexp = "[1-5]||''", message = "{is_ice.valid}") @JsonProperty("is")
    private String is_ice;
    @Pattern(regexp = "[0-2][0-9]||30||''", message = "{eses.valid}")
    private String eses;
    @Pattern(regexp = "[0-4]||''", message = "{rs.valid}")
    private String rs;
    //70HwaHwaHwa
    @Pattern(regexp = "[0-1][0-9][0-9]||200||''", message = "{hwahwahwa.valid}")
    private String hwaHwaHwa;
    //8swTbTbTb
    @Pattern(regexp = "[0-7]||''", message = "{sw.valid}")
    private String sw;
    @Pattern(regexp = "[0-3][0-9][0-9]||400||''", message = "{tbtbtb.valid}")
    private String tbTbTb;
    //ICE ciSibiDizi (ou ling. clara)
    @Pattern(regexp = "[0-9]||\\/||''", message = "{ci.valid}")
    private String ci;
    @Pattern(regexp = "[0-9]||\\/||''", message = "{si.valid}")
    private String si;
    @Pattern(regexp = "[0-9]||\\/||''", message = "{bi.valid}")
    private String bi;
    @Pattern(regexp = "[0-9]||\\/||''", message = "{di.valid}")
    private String di;
    @Pattern(regexp = "[0-9]||\\/||''", message = "{zi.valid}")
    private String zi;

    //SECTION 3

    //333
    //1snTxTxTx
    @Pattern(regexp = "[0-1]||''", message = "{sn1_3.valid}")
    private String sn1_3;
    @Pattern(regexp = "[0-3][0-9][0-9]||4[0-4][0-9]||450||''", message = "{txtxtx.valid}")
    private String txTxTx;
    //2snTnTnTn
    @Pattern(regexp = "[0-1]||''", message = "{sn2_3.valid}")
    private String sn2_3;
    @Pattern(regexp = "[0-2][0-9][0-9]||3[0-4][0-9]||350||''", message = "{tntntn.valid}")
    private String tnTnTn;
    //58/9P24P24P24
    @Pattern(regexp = "8||9||''", message = "{_89.valid}")
    private String ind89;
    @Pattern(regexp = "[0-1][0-9][0-9]||200||''", message = "{p24p24p24.valid}")
    private String p24P24P24;

    //SECTION 5

    //555
    //chwicMcsicFicpicQ
    @Pattern(regexp = "[0-3]||''", message = "{ichw.valid}")
    private String iChw;
    @Pattern(regexp = "[0-7]||''", message = "{icm.valid}")
    private String iCm;
    @Pattern(regexp = "[0-9]||''", message = "{cs.valid}")
    private String cs;
    @Pattern(regexp = "[0-6]||''", message = "{icf.valid}")
    private String iCF;
    @Pattern(regexp = "[0-9]||''", message = "{icp.valid}")
    private String iCP;
    @Pattern(regexp = "[0-9]||''", message = "{icq.valid}")
    private String iCQ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    private LocalDateTime dateObservation;
    private String observador;
    private String observerName;

    private Station station;
    private Observer observer;
}