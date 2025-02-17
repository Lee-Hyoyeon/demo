package com.hyodev.entity;

import java.time.LocalDateTime;
import java.util.List;
import com.hyodev.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "name is required")
    private String name;
    
    
    @Column(unique = true)
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "password num is required")
    private String password;

    @Column(name = "phone_number")
    @NotBlank(message = "phone num is required")
    private String phoneNumber;
    private UserRole role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orderItemList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
