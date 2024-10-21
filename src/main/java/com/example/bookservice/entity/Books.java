package com.example.bookservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    
    @Id
    @Column(name="id")
    long id;

    @Column(name="name")
    String name;
    
    @Column(name="prices")
    int prices;

    @Column(name="quantity")
    int quantity;




}
