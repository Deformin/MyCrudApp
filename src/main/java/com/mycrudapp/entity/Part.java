package com.mycrudapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "part")
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private boolean isNeeded;

    @Column
    private int amount;

    public Part() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeeded() {
        return isNeeded;
    }

    public void setNeeded(boolean needed) {
        isNeeded = needed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
