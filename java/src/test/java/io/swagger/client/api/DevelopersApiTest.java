package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Entity;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DevelopersApi
 */
@Ignore
public class DevelopersApiTest {

    private final DevelopersApi api = new DevelopersApi();

    
    /**
     * Get a list of all entities
     *
     * Get a list of all entities 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchEntitiesTest() throws ApiException {
        List<Entity> response = api.searchEntities();

        // TODO: test validations
    }
    
}
