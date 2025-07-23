package com.prodmix.api.mappers;

import com.prodmix.api.dtos.CreateOrganizationDto;
import com.prodmix.api.dtos.ResponseOrganizationDto;
import com.prodmix.api.dtos.UpdateOrganizationDto;
import com.prodmix.api.entities.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    //Para uma única Organization
    CreateOrganizationDto organizationToCreateOrganizationDto(Organization organization);
    Organization createOrganizationDTOToOrganization(CreateOrganizationDto dto);
    @Mapping(source = "id", target = "id")
    ResponseOrganizationDto organizationToResponseOrganizationDTO(Organization organization);
    Organization responseOrganizationDTOToOrganization(ResponseOrganizationDto dto);
    UpdateOrganizationDto organizationToUpdateOrganizationDTO(Organization organization);
    Organization updateOrganizationDTOToOrganization(UpdateOrganizationDto dto);

    //Para uma lista de Organizations
    List<ResponseOrganizationDto> organizationsToListDto(List<Organization> organizations);
}
