package com.ashoporders.mapper;

import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.ashoporders.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
   Order toEntity(CreateOrderRequestDto dto);
   CreateOrderRequestDto toDto(Order entity);
}
