package de.kersten.domain.route.resolver.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import de.kersten.domain.employee.Employee;
import de.kersten.domain.employee.EmployeeRepository;
import de.kersten.domain.route.Flight;
import de.kersten.domain.route.Route;
import de.kersten.domain.route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
* 
* @author Andre Kersten
*/

@Component
public class FlightQueryResolver implements GraphQLResolver<Flight> {

    private EmployeeRepository employeeRepository;
    private RouteRepository routeRepository;

    @Autowired
    public FlightQueryResolver(RouteRepository routeRepository,
    						   EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
        this.routeRepository=routeRepository;
    }

    public List<Employee> employees(Flight flight) {
        return employeeRepository.findByFlight(flight);
    }
    
    public Route route(Flight flight) {
    	return routeRepository.findById(flight.getRoute().getId()).get();
    }

}