package com.hyodev.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
  
  private int status;
  private String message;


private final LocalDateTime timestamp = LocalDateTime.now();

private String token;
private String role;
private String expirationTime;

private int titalPage;
private long totalElement;

private AddressDto address;

private UserDto user;
private List<UserDto> userList;


private CategoryDto category;
private List<CategoryDto> categoryList;

private ProductDto product;
private List<ProductDto> productList;

private OrderDto orderItem;
private List<OrderDto> orderItemList;


private OrderItemDto order;
private List<OrderItemDto> orderList;


}
