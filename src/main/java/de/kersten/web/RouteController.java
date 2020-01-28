package de.kersten.web;

import de.kersten.domain.route.Route;
import de.kersten.domain.route.RouteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * GraphQL Routes Controller
 *
 * @author Andre Kersten
 */


@RestController
public class RouteController {

    private RouteRepository routeRepository;

    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @GetMapping("routes")
    public List<Route> routes() {
        return routeRepository.findAll();

    }

}
