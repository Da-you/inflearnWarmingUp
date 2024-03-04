package com.group.libearyapp.homework4;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @Column(name = "is_sold",nullable = false)
    private boolean isSold = false;
    @Column(name = "warehousing_date")
    private LocalDate warehousingDate;

    public Fruit() {
    }

    public Fruit(Long id, String name, Long price, boolean isSold, LocalDate warehousingDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isSold = isSold;
        this.warehousingDate = warehousingDate;
    }

    public Fruit(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isIsSold() {
        return isSold;
    }

    public Long getPrice() {
        return price;
    }

    public void setIsSold(boolean sales) {
        this.isSold = sales;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
