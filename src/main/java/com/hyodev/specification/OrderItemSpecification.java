package com.hyodev.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;
import com.hyodev.entity.OrderItem;
import com.hyodev.enums.OrderStatus;

public class OrderItemSpecification {

  public static Specification<OrderItem> hasStatus (OrderStatus status){
    return ((root, query, CriteriaBuilder) -> status != null ? CriteriaBuilder.equal(root.get("status"), status)
    : null);

  }
  
  public static Specification<OrderItem> createdBetween (LocalDateTime startDate, LocalDateTime endDate){
    return ((root, query, CriteriaBuilder) -> {
      if (startDate != null && endDate != null) {
          return CriteriaBuilder.between(root.get("createdAt"), startDate,endDate);
      }
      else if (startDate != null ) {
        return CriteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), startDate);

      } else if (endDate != null) {
        return CriteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), endDate);
      } else {
        return null;
      }
    });
  }

  
  public static Specification<OrderItem> hasItemId (Long itemId){
    return ((root, query, CriteriaBuilder)->
    itemId != null ? CriteriaBuilder.equal(root.get("id"),itemId): null);
  }
}
