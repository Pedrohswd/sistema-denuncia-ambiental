package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
