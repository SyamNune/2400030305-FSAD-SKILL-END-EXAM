package com.klef.fsad.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_table")
public class Movie {

    @Id
    @Column(name = "movie_id")
    private int id;

    @Column(name = "movie_name", length = 100)
    private String name;

    @Column(name = "movie_date", length = 50)
    private String date;

    @Column(name = "movie_status", length = 50)
    private String status;

    // Getters and Setters

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", name=" + name + ", date=" + date + ", status=" + status + "]";
    }
}
