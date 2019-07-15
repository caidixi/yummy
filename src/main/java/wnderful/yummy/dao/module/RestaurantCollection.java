package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class RestaurantCollection {

    @Id
    @GeneratedValue
    private Long collectionId;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "restaurant_rid")
    private Restaurant restaurant;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "member_uid")
    private Member member;

    public RestaurantCollection() {
    }

    public RestaurantCollection(Restaurant restaurant, Member member) {
        this.restaurant = restaurant;
        this.member = member;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Member getMember() {
        return member;
    }
}
