package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.List;

@Entity
public class RestaurantState {
    @Id
    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy  = "restaurantState",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Restaurant> restaurantList;

    public RestaurantState() {
    }

    public RestaurantState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
