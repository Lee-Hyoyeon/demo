package com.hyodev.dto;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor

public class AddressDto {
  
  private Long id;

  private String street;
  private String city;
  private String state;
  private String zipCode;
  private String country;

  private UserDto user;

  private LocalDateTime createdAt ;
}
