package org.globant.entity;

import org.globant.helper.RentalStatus;

import java.time.LocalDate;

public class Rental {
    private int id;
    private LocalDate start_date;
    private LocalDate end_date;
    private RentalStatus status;
    private int customer_id;
    private int rental_machine_id;

    //constructor


    public Rental() {
    }

    public Rental(LocalDate start_date, LocalDate end_date, RentalStatus status, int customer_id, int rental_machine_id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.customer_id = customer_id;
        this.rental_machine_id = rental_machine_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRental_machine_id() {
        return rental_machine_id;
    }

    public void setRental_machine_id(int rental_machine_id) {
        this.rental_machine_id = rental_machine_id;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", status=" + status +
                ", customer_id=" + customer_id +
                ", rental_machine_id=" + rental_machine_id +
                '}';
    }
}
