package com.observation.persistence;

import com.observation.persistence.model.*;
import com.observation.persistence.payload.request.*;
import com.observation.persistence.payload.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStruct {

    MapStruct MAPPER = Mappers.getMapper(MapStruct.class);
    DTOResponseCommission toDTO(Commission commission);
    DTOResponseCompany toDTO(Company company);
    DTOResponseCountry toDTO(Country country);
    DTOResponseHarbor toDTO(Harbor harbor);
    DTOResponseEquipment toDTO(Equipment equipment);
    DTOResponseFederativeUnit toDTO(FederativeUnit federativeUnit);
    DTOResponseIndividual toDTO(Individual individual);
    DTOResponseInstitution toDTO(Institution institution);
    DTOResponseManufacturer toDTO(Manufacturer manufacturer);
    DTOResponseObserver toDTO(Observer observer);
    DTOResponseOM toDTO(OM om);
    DTOResponsePerson toDTO(Person person);
    DTOResponsePlatform toDTO(Platform platform);
    DTOResponsePlatformCategory toDTO(PlatformCategory platformCategory);
    DTOResponseResearcher toDTO(Researcher researcher);
    DTOResponseRole toDTO(Role role);
    DTOResponseStation toDTO(Station station);
    DTOResponseStationHistoric toDTO(StationHistoric stationHistoric);
    DTOResponseStationHistoricOffShore toDTO(StationHistoricOffShore stationHistoricOffShore);
    DTOResponseStationHistoricOnShore toDTO(StationHistoricOnShore stationHistoricOnShore);
    DTOResponseStationCategory toDTO(StationCategory stationCategory);
    DTOResponseStationOffShore toDTO(StationOffShore stationOffShore);
    DTOResponseStationOnShore toDTO(StationOnShore stationOnShore);
    DTOResponseSurveying toDTO(Surveying surveying);
    DTOResponseWeather toDTO(Weather weather);
//    @Mapping(target = "a1", ignore = true)
//    @Mapping(target = "bw", ignore = true)
//    @Mapping(target = "nbNbNb", ignore = true)
//    @Mapping(target = "sn2_1", ignore = true)
//    @Mapping(target = "tdTdTd", ignore = true)
//    @Mapping(target = "poPoPoPo", ignore = true)
//    @Mapping(target = "a3", ignore = true)
//    @Mapping(target = "hhh", ignore = true)
//    @Mapping(target = "a", ignore = true)
//    @Mapping(target = "ppp", ignore = true)
//    @Mapping(target = "rrr", ignore = true)
//    @Mapping(target = "tr", ignore = true)
//    @Mapping(target = "waWa", ignore = true)
//    @Mapping(target = "wa1", ignore = true)
//    @Mapping(target = "wa2", ignore = true)
//    @Mapping(target = "gggg", ignore = true)
//    @Mapping(target = "ss", ignore = true)
//    @Mapping(target = "twTwTw", ignore = true)
//    @Mapping(target = "pwaPwa", ignore = true)
//    @Mapping(target = "hwaHwa", ignore = true)
//    @Mapping(target = "pwPw", ignore = true)
//    @Mapping(target = "hwHw", ignore = true)
//    @Mapping(target = "dw1Dw1", ignore = true)
//    @Mapping(target = "dw2Dw2", ignore = true)
//    @Mapping(target = "pw1Pw1", ignore = true)
//    @Mapping(target = "hw1Hw1", ignore = true)
//    @Mapping(target = "pw2Pw2", ignore = true)
//    @Mapping(target = "hw2Hw2", ignore = true)
//    @Mapping(target = "is_ice", ignore = true)
//    @Mapping(target = "eses", ignore = true)
//    @Mapping(target = "rs", ignore = true)
//    @Mapping(target = "hwaHwaHwa", ignore = true)
//    @Mapping(target = "sw", ignore = true)
//    @Mapping(target = "tbTbTb", ignore = true)
//    @Mapping(target = "ci", ignore = true)
//    @Mapping(target = "si", ignore = true)
//    @Mapping(target = "bi", ignore = true)
//    @Mapping(target = "di", ignore = true)
//    @Mapping(target = "zi", ignore = true)
//    @Mapping(target = "sn1_3", ignore = true)
//    @Mapping(target = "txTxTx", ignore = true)
//    @Mapping(target = "sn2_3", ignore = true)
//    @Mapping(target = "tnTnTn", ignore = true)
//    @Mapping(target = "ind89", ignore = true)
//    @Mapping(target = "p24P24P24", ignore = true)
//    @Mapping(target = "iChw", ignore = true)
//    @Mapping(target = "iCm", ignore = true)
//    @Mapping(target = "cs", ignore = true)
//    @Mapping(target = "iCf", ignore = true)
//    @Mapping(target = "iCp", ignore = true)
//    @Mapping(target = "iCq", ignore = true)
//    @Mapping(target = "dataObservacao", ignore = true)
//    @Mapping(target = "dateObservation", ignore = true)
//    @Mapping(target = "observador", ignore = true)
//    @Mapping(target = "observerName", ignore = true)
//    @Mapping(target = "station", ignore = true)
//    @Mapping(target = "observer", ignore = true)
    DTOResponseWeatherAbbreviated toDTOAbbreviated(Weather weather);
//    @Mapping(target = "a1", ignore = true)
//    @Mapping(target = "bw", ignore = true)
//    @Mapping(target = "nbNbNb", ignore = true)
//    @Mapping(target = "sn2_1", ignore = true)
//    @Mapping(target = "tdTdTd", ignore = true)
//    @Mapping(target = "poPoPoPo", ignore = true)
//    @Mapping(target = "a3", ignore = true)
//    @Mapping(target = "hhh", ignore = true)
//    @Mapping(target = "a", ignore = true)
//    @Mapping(target = "ppp", ignore = true)
//    @Mapping(target = "rrr", ignore = true)
//    @Mapping(target = "tr", ignore = true)
//    @Mapping(target = "waWa", ignore = true)
//    @Mapping(target = "wa1", ignore = true)
//    @Mapping(target = "wa2", ignore = true)
//    @Mapping(target = "nh", ignore = true)
//    @Mapping(target = "cl", ignore = true)
//    @Mapping(target = "cm", ignore = true)
//    @Mapping(target = "ch", ignore = true)
//    @Mapping(target = "gggg", ignore = true)
//    @Mapping(target = "ss", ignore = true)
//    @Mapping(target = "twTwTw", ignore = true)
//    @Mapping(target = "pwaPwa", ignore = true)
//    @Mapping(target = "hwaHwa", ignore = true)
//    @Mapping(target = "pwPw", ignore = true)
//    @Mapping(target = "hwHw", ignore = true)
//    @Mapping(target = "dw1Dw1", ignore = true)
//    @Mapping(target = "dw2Dw2", ignore = true)
//    @Mapping(target = "pw1Pw1", ignore = true)
//    @Mapping(target = "hw1Hw1", ignore = true)
//    @Mapping(target = "pw2Pw2", ignore = true)
//    @Mapping(target = "hw2Hw2", ignore = true)
//    @Mapping(target = "is_ice", ignore = true)
//    @Mapping(target = "eses", ignore = true)
//    @Mapping(target = "rs", ignore = true)
//    @Mapping(target = "hwaHwaHwa", ignore = true)
//    @Mapping(target = "sw", ignore = true)
//    @Mapping(target = "tbTbTb", ignore = true)
//    @Mapping(target = "ci", ignore = true)
//    @Mapping(target = "si", ignore = true)
//    @Mapping(target = "bi", ignore = true)
//    @Mapping(target = "di", ignore = true)
//    @Mapping(target = "zi", ignore = true)
//    @Mapping(target = "sn1_3", ignore = true)
//    @Mapping(target = "txTxTx", ignore = true)
//    @Mapping(target = "sn2_3", ignore = true)
//    @Mapping(target = "tnTnTn", ignore = true)
//    @Mapping(target = "ind89", ignore = true)
//    @Mapping(target = "p24P24P24", ignore = true)
//    @Mapping(target = "iChw", ignore = true)
//    @Mapping(target = "iCm", ignore = true)
//    @Mapping(target = "cs", ignore = true)
//    @Mapping(target = "iCf", ignore = true)
//    @Mapping(target = "iCp", ignore = true)
//    @Mapping(target = "iCq", ignore = true)
//    @Mapping(target = "dataObservacao", ignore = true)
//    @Mapping(target = "dateObservation", ignore = true)
//    @Mapping(target = "observador", ignore = true)
//    @Mapping(target = "observerName", ignore = true)
//    @Mapping(target = "station", ignore = true)
//    @Mapping(target = "observer", ignore = true)
    DTOResponseWeatherReduced toDTOReduced(Weather weather);
    DTOResponseWeatherHistoric toDTO(WeatherHistoric weatherHistoric);
    DTOResponseWeatherHistoricOffShore toDTO(WeatherHistoricOffShore weatherHistoricOffShore);
    DTOResponseWeatherHistoricOnShore toDTO(WeatherHistoricOnShore weatherHistoricOnShore);
    DTOResponseUserEntity toDTO(UserEntity userEntity);
    DTOResponsePrivilege toDTO(Privilege privilege);

    Commission toObject(DTORequestCommission dtoRequestCommission);
    Company toObject(DTORequestCompany dtoRequestCompany);
    Country toObject(DTORequestCountry dtoRequestCountry);
    Harbor toObject(DTORequestHarbor dtoRequestHarbor);
    Equipment toObject(DTORequestEquipment dtoRequestEquipment);
    FederativeUnit toObject(DTORequestFederativeUnit dtoRequestFederativeUnit);
    Individual toObject(DTORequestIndividual dtoRequestIndividual);
    Institution toObject(DTORequestInstitution dtoRequestInstitution);
    Manufacturer toObject(DTORequestManufacturer dtoRequestManufacturer);
    Observer toObject(DTORequestObserver dtoRequestObserver);
    OM toObject(DTORequestOM dtoRequestOM);
    Person toObject(DTORequestPerson dtoRequestPerson);
    Platform toObject(DTORequestPlatform dtoRequestPlatform);
    PlatformCategory toObject(DTORequestPlatformCategory dtoRequestPlatformCategory);
    Researcher toObject(DTORequestResearcher dtoRequestResearcher);
    Role toObject(DTORequestRole dtoRequestRole);
    Station toObject(DTORequestStation dtoRequestStation);
    StationHistoric toObject(DTORequestStationHistoric dtoRequestStationHistoric);
    StationHistoricOffShore toObject(DTORequestStationHistoricOffShore dtoRequestStationHistoricOffShore);
    StationHistoricOnShore toObject(DTORequestStationHistoricOnShore dtoRequestStationHistoricOnShore);
    StationCategory toObject(DTORequestStationCategory dtoRequestStationCategory);
    StationOffShore toObject(DTORequestStationOffShore dtoRequestStationOffShore);
    StationOnShore toObject(DTORequestStationOnShore dtoRequestStationOnShore);
    Surveying toObject(DTORequestSurveying dtoRequestSurveying);
    Weather toObject(DTORequestWeather dtoRequestWeather);
    WeatherHistoric toObject(DTORequestWeatherHistoric dtoRequestWeatherHistoric);
    WeatherHistoricOffShore toObject(DTORequestWeatherHistoricOffShore dtoRequestWeatherHistoricOffShore);
    WeatherHistoricOnShore toObject(DTORequestWeatherHistoricOnShore dtoRequestWeatherHistoricOnShore);
    UserEntity toObject(DTORequestUserEntity dtoRequestUserEntity);
    Privilege toObject(DTORequestPrivilege dtoRequestPrivilege);
}