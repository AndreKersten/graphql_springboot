package de.kersten.domain.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.kersten.domain.AbstractEntity;
import de.kersten.domain.route.Flight;

import javax.persistence.*;

/**
 * Employee Entity
 * <p>
 * Used Patterns:
 * discriminator pattern
 *
 * @author Andre Kersten
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends AbstractEntity {

    private String staffNumber;
    private String lastName;
    private String firstName;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @ManyToOne
    @JsonIgnore
    private Flight flight;

    public Employee() {
        super();
    }

    public Employee(String staffNumber) {
        super();
        this.staffNumber = staffNumber;
    }

    public Employee(String staffNumber, String firstName, String lastName) {
        super();
        this.staffNumber = staffNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public EmployeeRole getRole() {
        return this.role;
    }
}

