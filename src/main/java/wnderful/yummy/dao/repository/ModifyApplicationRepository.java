package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.ModifyApplication;
import wnderful.yummy.dao.module.Restaurant;

public interface ModifyApplicationRepository extends JpaRepository<ModifyApplication,Long> {
    ModifyApplication findByRid(String rid);
}
