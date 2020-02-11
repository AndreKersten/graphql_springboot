package de.kersten;

import com.coxautodev.graphql.tools.SchemaParserDictionary;
import de.kersten.domain.employee.Pilot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfiguration {

    /**
     * Register own SchemaParser that is aware of our own classes
     * @return
     */
    @Bean
    public SchemaParserDictionary schemaParserDictionary() {
        return new SchemaParserDictionary()
                .add(Pilot.class);
    }

}