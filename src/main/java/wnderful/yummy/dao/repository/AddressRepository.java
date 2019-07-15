package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByAddressId(Long addressId);
}
