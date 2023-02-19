package com.example.Springsimpleproject.model.entity;

import com.google.gson.Gson;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "orderEntity")
@Table(name = "orderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Double price;

    // Many-to-one relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // One-to-one relationship with Payment entity
    @OneToOne(mappedBy = "order")
    private Payment payment;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}