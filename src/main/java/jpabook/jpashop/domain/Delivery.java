package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ordinal 절대 쓰지말고 String쓰기 중간에 다른 게 하나 생기는순간 ordinal 다 에러남
    private DeliveryStatus status; // READY,COMP
}
