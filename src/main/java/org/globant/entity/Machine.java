package org.globant.entity;

import org.globant.helper.MachineStatus;

public class Machine {
    private int id;
    private String model;
    private String serie;
    private MachineStatus state;
    private int rental_machine_id;

    public Machine() {
    }

    public Machine(String model, String serie) {
        this.model = model;
        this.serie = serie;
    }

    public Machine(String model, String serie, MachineStatus state) {
        this.model = model;
        this.serie = serie;
        this.state = state;
    }

    //Complete
    public Machine(String model, String serie, MachineStatus state, int rental_machine_id) {
        this.model = model;
        this.serie = serie;
        this.state = state;
        this.rental_machine_id = rental_machine_id;
    }



    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public MachineStatus getState() {
        return state;
    }

    public void setState(MachineStatus state) {
        this.state = state;
    }

    public int getRental_machine_id() {
        return rental_machine_id;
    }

    public void setRental_machine_id(int rental_machine_id) {
        this.rental_machine_id = rental_machine_id;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serie='" + serie + '\'' +
                ", state=" + state +
                ", rental_machine_id=" + rental_machine_id +
                '}';
    }
}
