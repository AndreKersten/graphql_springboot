package de.kersten.test;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode=ClassMode.BEFORE_EACH_TEST_METHOD)
public class GraphQLRouteMutationTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

   
    @Test
    public void routeQueryDeleteRoute() throws IOException {       
        GraphQLResponse response  = graphQLTestTemplate.postForResource("deleteRoute.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals(true, response.get("$.data.deleteRoute", Boolean.class));
    }
       
}