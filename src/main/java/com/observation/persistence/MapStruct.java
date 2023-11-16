package com.observation.persistence;

import com.observation.persistence.model.*;
import com.observation.persistence.payload.request.*;
import com.observation.persistence.payload.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
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