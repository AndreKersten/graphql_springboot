package de.kersten.domain.route.resolver.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import de.kersten.domain.route.Route;
import de.kersten.domain.route.publisher.RouteUpdatePublisher;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**  
* GraphQL Spring Boot Samples
* All Rights Reserved.
* 
* @author Andre Kersten
*/

@Component
public class RootSubscriptionResolver implements GraphQLSubscriptionResolver {

        RouteUpdatePublisher routeUpdatePublisher;

        @Autowired
        public RootSubscriptionResolver(RouteUpdatePublisher routeUpdatePublisher) {
                this.routeUpdatePublisher=routeUpdatePublisher;
        }

        public Publisher<Route> registerRouteCreated() {
                return routeUpdatePublisher.getPublisher();
        }

}