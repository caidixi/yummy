package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.Restaurant;
import wnderful.yummy.dao.module.RestaurantCollection;

import java.util.List;

public interface RestaurantCollectionRepository extends JpaRepository<RestaurantCollection,Long> {
    RestaurantCollection findByRestaurantAndMember(Restaurant restaurant, Member member);

    List<RestaurantCollection> findByMember(Member member);
}
