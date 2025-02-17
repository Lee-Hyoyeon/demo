package com.hyodev.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import com.hyodev.dto.UserDto;
import com.hyodev.entity.User;
import com.hyodev.exception.NotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  
  private final UserDto userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByemail(username)
    .orElseThrow(()-> new NotFoundException("User/ email not found"));

    return AuthUser.builder().user(user).build();
  }





}
