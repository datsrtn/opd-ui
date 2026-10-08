
package com.myopd.opd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.myopd.opd.dto.UnitDTO;
import com.myopd.opd.entity.Unit;

@Mapper(componentModel = "spring")

public interface UnitMapper {
	UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

	UnitDTO toDTO(Unit unit);

	Unit toEUnit(UnitDTO uinitDto);
}
