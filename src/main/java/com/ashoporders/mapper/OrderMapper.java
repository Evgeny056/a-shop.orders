package com.ashoporders.mapper;

import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.ashoporders.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

   OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

   @Mapping(source = "userId", target = "user.userId")
   Order toEntity(CreateOrderRequestDto dto);

   @Mapping(source = "user.userId", target = "userId")
   CreateOrderRequestDto toDto(Order entity);
}
