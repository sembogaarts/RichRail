package com.richrail.domain;

public class Wagon implements RollingComponent {
    private String id = "wagon";
    private int seats = 10;

    public Wagon() {

    }

    public Wagon(String id) {
        this.id = id;
    }

    public Wagon(String id, int seats) {
        this.id = id;
        this.seats = seats;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

}
