package de.kersten.domain.route.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.kersten.domain.route.Route;
import de.kersten.domain.route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * GraphQL Spring Boot Samples
 *
 *
 * @author Andre Kersten
 */


@Component
public class RootQueryResolver implements GraphQLQueryResolver {

    private RouteRepository routeRepository;

    @Autowired
    public RootQueryResolver(RouteRepository routeRepository) {
        this.routeRepository=routeRepository;
    }

    // routes: [Route] as defined in typeDefs.graphql
    public List<Route> routes() {
        return routeRepository.findAll();
    }

    // route(flightNumber: String!): Route
    public Route route(String flightNumber) {
        return routeRepository.findByFlightNumber(flightNumber);
    }

}

