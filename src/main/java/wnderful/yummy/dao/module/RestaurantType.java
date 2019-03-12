package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.List;

@Entity
public class RestaurantType {
    @Id
    @GeneratedValue
    private Long typeId;

    @Column(nullable = false,unique = true,columnDefinition = "varchar(255) character set utf8")
    private String name;

    @OneToMany(mappedBy  = "restaurantType",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Restaurant> restaurantList;

    public RestaurantType() {
    }

    public RestaurantType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
