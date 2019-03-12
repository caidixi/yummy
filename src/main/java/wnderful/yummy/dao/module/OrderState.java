package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderState {
    @Id
    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy  = "orderState",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;

    public OrderState() {
    }

    public OrderState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
