package com.richrail.domain;

public class Wagon implements RollingComponent {
    private String id = "wagon";

    public Wagon(String id) {
        this.id = id;
    }

    public Wagon() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

}
