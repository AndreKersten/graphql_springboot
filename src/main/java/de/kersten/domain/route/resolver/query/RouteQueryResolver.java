package de.kersten.domain.route.resolver.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import de.kersten.domain.route.Flight;
import de.kersten.domain.route.FlightRepository;
import de.kersten.domain.route.Route;
import de.kersten.domain.route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**  
* Route Resolver to fetch referenced objects
 *
 * see type Route in typeDefs.graphql
* 
* @author Andre Kersten
*/

@Component
public class RouteQueryResolver implements GraphQLResolver<Route> {

    private FlightRepository flightRepository;
    private RouteRepository routeRepository;

    @Autowired
    public RouteQueryResolver(RouteRepository routeRepository,
    					      FlightRepository flightRepository) {
    	this.routeRepository=routeRepository;
        this.flightRepository=flightRepository;
    }

    public List<Flight> flights(Route route) {
        return flightRepository.findByRoute(route);	
    }

    public Route route(Route route) {
    	return routeRepository.findByRoute(route);
    }

    // routes: [Route] as defined in typeDefs.graphql
    public List<Route> routes() {
        return routeRepository.findAll();
    }

}