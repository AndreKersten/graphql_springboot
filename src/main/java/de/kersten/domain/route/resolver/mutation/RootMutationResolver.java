package de.kersten.domain.route.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.kersten.domain.route.Route;
import de.kersten.domain.route.RouteRepository;
import de.kersten.domain.route.publisher.RouteUpdatePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**  
*spring service to handle route mutation requests
* 
* @author Andre Kersten
*/

@Service 
public class RootMutationResolver implements GraphQLMutationResolver {

    private RouteRepository routeRepository;
    private RouteUpdatePublisher routeUpdatePublisher;

    @Autowired
    public RootMutationResolver(RouteRepository routeRepository,
                                RouteUpdatePublisher routeUpdatePublisher) {
        this.routeRepository=routeRepository;	
        this.routeUpdatePublisher=routeUpdatePublisher;
    }
 
    public Route createRoute(String flightNumber) {
        Route route = new Route(flightNumber);
        routeRepository.save(route);
        return route; 
    }

    public Route updateRoute(Long id, String departure) {
        Route route = routeRepository.findById(id).get();
        route.setDeparture(departure);
        routeRepository.save(route);
        return route;
    }

    public Route updateRouteWithRouteInput(Long id, RouteInput input) {
        Route route = routeRepository.findById(id).get();
        route.setDeparture(input.getDeparture());
        route.setDestination(input.getDestination());
        routeRepository.save(route);
        return route;
    }

    public Boolean deleteRoute(Long id) {
        routeRepository.deleteById(id);
        return true;

    }

}