package de.kersten.domain.route;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Flight Repository
 *
 * @author Andre Kersten
 */

public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Query("select f from Flight f where f.route = :route")
    List<Flight> findByRoute(@Param("route") Route route);

}
