
package com.example.statisticsapi.mapper;

import com.example.statisticsapi.config.MapperConfig;
import com.example.statisticsapi.document.SalesAndTrafficByAsin;
import com.example.statisticsapi.dto.external.SalesAndTrafficByAsinDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SalesAndTrafficByAsinMapper {
    SalesAndTrafficByAsinDto toDto(SalesAndTrafficByAsin salesAndTrafficByAsin);
}
