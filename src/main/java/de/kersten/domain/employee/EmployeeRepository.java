package de.kersten.domain.employee;

import de.kersten.domain.route.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Employee Repository
 *
 * @author Andre Kersten
 */

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e")
    List<Employee> findAll();

    @Query("select e from Employee e where e.flight = :flight")
    List<Employee> findByFlight(@Param("flight") Flight flight);
}
