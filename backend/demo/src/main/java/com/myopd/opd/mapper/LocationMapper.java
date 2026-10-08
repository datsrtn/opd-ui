package com.myopd.opd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.myopd.opd.dto.LocationDTO;
import com.myopd.opd.entity.Location;


@Mapper(componentModel = "spring")
public interface LocationMapper {
	
	LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

	LocationDTO toDTO(Location location);

	Location toLocation(LocationDTO locationDto);
}
