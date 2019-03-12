package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Manager;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    Manager findByEmail(String email);
    Manager findByMid(Long mid);
}
