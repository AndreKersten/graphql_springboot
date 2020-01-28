package de.kersten.domain.route;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.kersten.domain.AbstractEntity;
import de.kersten.domain.employee.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Flight Entity - represents a flight.
 * <p>
 * Employees can be assigned to a flight.
 * A flight can be assigned to multiple Routes
 *
 * @author Andre Kersten
 */

@Entity
public class Flight extends AbstractEntity {

    private double price;

    private LocalDate date;

    @ManyToOne
    @JsonIgnore
    private Route route;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Employee> employees;


    public Flight() {
        super();
    }

    public Flight(double price, LocalDate date) {
        super();
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
