package com.example.statisticsapi.mapper;

import com.example.statisticsapi.config.MapperConfig;
import com.example.statisticsapi.document.SalesAndTrafficByDate;
import com.example.statisticsapi.dto.external.SalesAndTrafficByDateDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SalesAndTrafficByDateMapper {
    SalesAndTrafficByDateDto toDto(SalesAndTrafficByDate salesAndTrafficByDate);
}
