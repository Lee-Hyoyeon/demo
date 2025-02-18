package com.hyodev.service.interf;

import com.hyodev.dto.AddressDto;
import com.hyodev.dto.Response;

public interface AddressService {
    Response saveAndUpdateAddress (AddressDto addressDto);
  

}
