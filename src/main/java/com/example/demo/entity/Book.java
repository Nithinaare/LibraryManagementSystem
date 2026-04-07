package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bname;

    private String avail;
    private int count;

    public String getBname() {
        return bname;
    }


    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public String getAvail() {
        return avail;
    }

    public int getCount() {
        return count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}