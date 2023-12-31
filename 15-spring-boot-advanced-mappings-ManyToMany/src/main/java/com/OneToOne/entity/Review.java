package com.OneToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    // define fields

    // define constructors

    // define getter/setters

    // define toString

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public Review(){}

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "Id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
