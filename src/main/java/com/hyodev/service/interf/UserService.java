package com.hyodev.service.interf;

import com.hyodev.dto.LoginRequest;
import com.hyodev.dto.Response;
import com.hyodev.dto.UserDto;
import com.hyodev.entity.User;

public interface UserService {
  Response registerUser (UserDto registrationRequest);
  Response loginUser (LoginRequest loginRequest);
  Response getAllUsers();
  User getLoginUser();

  Response getUserInfoAndOrderHistory();

  
}
