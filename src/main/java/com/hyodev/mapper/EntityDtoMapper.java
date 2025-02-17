package com.hyodev.mapper;

import java.util.Locale.Category;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.hyodev.dto.AddressDto;
import com.hyodev.dto.CategoryDto;
import com.hyodev.dto.OrderItemDto;
import com.hyodev.dto.ProductDto;
import com.hyodev.dto.UserDto;
import com.hyodev.entity.Address;
import com.hyodev.entity.OrderItem;
import com.hyodev.entity.Product;
import com.hyodev.entity.User;

@Component
public class EntityDtoMapper {

  //user entity to DTO
  public UserDto mapUserToDtoBasic(User user){
    
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setPhoneNumber(user.getPhoneNumber());
    userDto.setEmail(user.getEmail());
    userDto.setRole(user.getRole().name());
    userDto.setName(user.getName());
        return userDto;
  }

  public AddressDto mapAddressToDtoBasic(Address address) {
    return AddressDto.builder()
        .id(address.getId())
        .city(address.getCity())
        .state(address.getState())  // state 필드 올바르게 매핑
        .country(address.getCountry())
        .zipCode(address.getZipCode())
        .street(address.getStreet())
        .build();
}

public CategoryDto mapUserToDtoBasic(Category category){
  CategoryDto cd = new CategoryDto();
  cd.setId(cd.getId());
  cd.setName(cd.getName());
      return cd;
}

public OrderItemDto mapOrderItemToDtoBasic(OrderItem orderItem){
  OrderItemDto orderItemDto = new OrderItemDto();
  orderItemDto.setId(orderItem.getId());
  orderItemDto.setQuantity(orderItem.getQuantity());
  orderItemDto.setPrice(orderItem.getPrice());
  orderItemDto.setStatus(orderItem.getStatus().name());
  orderItemDto.setCreatedAt(orderItem.getCreatedAt());
    return orderItemDto;
}

public ProductDto mapProductToDtoBasic(Product product) {
  ProductDto productDto = new ProductDto();
  productDto.setId(product.getId());
  productDto.setName(product.getName());
  productDto.setDescription(product.getDescription());
  productDto.setPrice(product.getPrice());
  productDto.setImageUrl(product.getImageUrl());
    return productDto;
}


public OrderItemDto mapOrderItemDtoPlusProduct(OrderItem orderItem){
  OrderItemDto orderItemDto = mapOrderItemToDtoBasic(orderItem);

  if(orderItemDto.getProduct() != null ){
    ProductDto productDto = mapProductToDtoBasic(orderItem.getProduct());
    orderItemDto.setProduct(productDto);
  }
  return orderItemDto;
}

public CategoryDto mapCategoryDtoBasic (com.hyodev.entity.Category category){
  CategoryDto categoryDto = new CategoryDto();
  categoryDto.setId(category.getId());
  categoryDto.setName(category.getName());
    return categoryDto;
  
}
public OrderItemDto mapOrderItemDtoBasic (OrderItem orderItem){
  OrderItemDto orderItemDto = new OrderItemDto();
  orderItemDto.setId(orderItem.getId());
  orderItemDto.setQuantity(orderItem.getQuantity());
  orderItemDto.setPrice(orderItem.getPrice());
  orderItemDto.setStatus(orderItem.getStatus().name());
  orderItemDto.setCreatedAt(orderItem.getCreatedAt());
    return orderItemDto;

}
public ProductDto maProductToDtoBasic (Product product){
  ProductDto productDto = new ProductDto();
  productDto.setId(product.getId());
  productDto.setName(product.getName());
  productDto.setDescription(product.getDescription());
  productDto.setPrice(product.getPrice());
  productDto.setImageUrl(product.getImageUrl());
    return productDto;
    

}

public UserDto mapUserToDtoPlusAddress (User user){
  UserDto userDto = mapUserToDtoBasic(user);
  if (user.getAddress()!=null) {
    AddressDto addressDto = mapAddressToDtoBasic(user.getAddress());
    userDto.setAddress(addressDto);
  }
  return userDto;
}
public OrderItemDto mapOrderItemToDtoPlusProduct(OrderItem orderItem){
  OrderItemDto orderItemDto = mapOrderItemDtoBasic(orderItem);

  if(orderItemDto.getProduct() != null){
    ProductDto productDto = mapProductToDtoBasic(orderItem.getProduct());
    orderItemDto.setProduct(productDto);
  }
  return orderItemDto;
}


public OrderItemDto mapOrderItemToDtoPlusProductAndUser(OrderItem orderItem){
    OrderItemDto orderItemDto = mapOrderItemToDtoPlusProduct(orderItem);
if(orderItem.getUser()!= null){
  UserDto userDto = mapUserToDtoPlusAddress(orderItem.getUser());
  orderItemDto.setUser(userDto);
}
    return orderItemDto;
}

public UserDto mapUserToDtoPlusAddressAndOrderHistory(User user) {
  UserDto userDto = mapUserToDtoPlusAddress(user);

  if (user.getOrderItemList() != null && !user.getOrderItemList().isEmpty()) {
      userDto.setOrderItemList(user.getOrderItemList()
          .stream()
          .map(this::mapOrderItemDtoPlusProduct) // Make sure this method exists in this class
          .collect(Collectors.toList()));
  }
  return userDto;
}




}








