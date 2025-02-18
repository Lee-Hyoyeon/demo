package com.hyodev.service.impl;

import org.springframework.stereotype.Service;

import com.hyodev.dto.AddressDto;
import com.hyodev.dto.Response;
import com.hyodev.entity.Address;
import com.hyodev.entity.User;
import com.hyodev.repository.AddressRepo;
import com.hyodev.service.interf.AddressService;
import com.hyodev.service.interf.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
  
  private final AddressRepo addressRepo;
  private final UserService userService;

  @Override
  public Response saveAndUpdateAddress(AddressDto addressDto) {
    User user = userService.getLoginUser();
    Address address = user.getAddress();
    
    if (address == null) {
      address = new Address();
      address.setUser(user);

    }

    if (addressDto.getStreet()!=null ) address.setStreet(addressDto.getStreet());
    if (addressDto.getCity()!=null ) address.setStreet(addressDto.getStreet());
    if (addressDto.getState()!=null ) address.setStreet(addressDto.getStreet());
    if (addressDto.getZipCode()!=null ) address.setStreet(addressDto.getStreet());
    if (addressDto.getCountry()!=null ) address.setStreet(addressDto.getStreet());
    
    addressRepo.save(address);
    String message = (user.getAddress()== null)? "Address succesfully created" : "address successfully updated";

    return Response.builder().status(200).message(message).build();

  }

}
