
package de.kersten.domain.route;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Route Repository
 *
 * @author Andre Kersten
 */

public interface RouteRepository extends CrudRepository<Route, Long> {

    Route findByFlightNumber(String flightNumber);

    @Query("select r from Route r")
    List<Route> findAll();

    @Query("select r from Route r where r.parent = :route")
    Route findByRoute(@Param("route") Route route);


}