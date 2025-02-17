package com.hyodev.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hyodev.entity.Payment;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
  

private BigDecimal totalPrice;
private List<orderItemRequest> items;

private Payment paymentInfo;


}
