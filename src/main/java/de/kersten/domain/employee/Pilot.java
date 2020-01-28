package de.kersten.domain.employee;

import javax.persistence.Entity;

/**
 * Pilot Entity
 *
 * @author Andre Kersten
 */

@Entity
public class Pilot extends Employee {

    String certificateNumber;

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

}