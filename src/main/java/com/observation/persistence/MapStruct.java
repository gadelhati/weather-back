package com.observation.persistence;

import com.observation.persistence.model.*;
import com.observation.persistence.payload.request.*;
import com.observation.persistence.payload.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
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
//    DTOResponseJwt toDTO(Jwt jwt);
//    DTOResponseLogOut toDTO(Company company);
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
    DTOResponseStationCategory toDTO(StationCategory stationCategory);
    DTOResponseStationOffShore toDTO(StationOffShore stationOffShore);
    DTOResponseStationOnShore toDTO(StationOnShore stationOnShore);
    DTOResponseSurveying toDTO(Surveying surveying);
    DTOResponseSynopticObservation toDTO(SynopticObservation synopticObservation);
    DTOResponseSynopticObservationHistoric toDTO(SynopticObservationHistoric synopticObservationHistoric);
    DTOResponseSynopticObservationHistoricOffShore toDTO(SynopticObservationHistoricOffShore synopticObservationHistoricOffShore);
    DTOResponseSynopticObservationHistoricOnShore toDTO(SynopticObservationHistoricOnShore synopticObservationHistoricOnShore);
//    DTOResponseTokenRefresh toDTO(TokenRef);
    DTOResponseUser toDTO(User user);
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
//    Jwt toObject(DTORequestJwt dtoRequestJwt);
//    LogOut toObject(DTORequestLogOut dtoRequestLogOut);
    OM toObject(DTORequestOM dtoRequestOM);
    Person toObject(DTORequestPerson dtoRequestPerson);
    Platform toObject(DTORequestPlatform dtoRequestPlatform);
    PlatformCategory toObject(DTORequestPlatformCategory dtoRequestPlatformCategory);
    Researcher toObject(DTORequestResearcher dtoRequestResearcher);
    Role toObject(DTORequestRole dtoRequestRole);
    Station toObject(DTORequestStation dtoRequestStation);
    StationHistoric toObject(DTORequestStationHistoric dtoRequestStationHistoric);
    StationCategory toObject(DTORequestStationCategory dtoRequestStationCategory);
    StationOffShore toObject(DTORequestStationOffShore dtoRequestStationOffShore);
    StationOnShore toObject(DTORequestStationOnShore dtoRequestStationOnShore);
    Surveying toObject(DTORequestSurveying dtoRequestSurveying);
    SynopticObservation toObject(DTORequestSynopticObservation dtoRequestSynopticObservation);
    SynopticObservationHistoric toObject(DTORequestSynopticObservationHistoric dtoRequestSynopticObservationHistoric);
    SynopticObservationHistoricOffShore toObject(DTORequestSynopticObservationHistoricOffShore dtoRequestSynopticObservationHistoricOffShore);
    SynopticObservationHistoricOnShore toObject(DTORequestSynopticObservationHistoricOnShore dtoRequestSynopticObservationHistoricOnShore);
//    TokenRefresh toObject(DTORequestTokenRefresh tokenRefresh);
    User toObject(DTORequestUser dtoRequestUser);
    UserEntity toObject(DTORequestUserEntity dtoRequestUserEntity);
    Privilege toObject(DTORequestPrivilege dtoRequestPrivilege);
}