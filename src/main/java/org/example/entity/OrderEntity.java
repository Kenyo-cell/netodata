package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "date")
    Date date;

    @Column(name = "product_name")
    String productName;

    @Column(name = "amount")
    double amount;

    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(targetEntity = CustomerEntity.class)
    CustomerEntity customer;
}
