package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodState {
    @Id
    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy  = "foodState",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Food> foods;

    public FoodState() {
    }

    public FoodState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
