package com.hyodev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyodev.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
