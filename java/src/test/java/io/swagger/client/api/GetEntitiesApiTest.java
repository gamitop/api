package io.swagger.client.api;

import io.swagger.client.ApiException;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GetEntitiesApi
 */
@Ignore
public class GetEntitiesApiTest {

    private final GetEntitiesApi api = new GetEntitiesApi();

    
    /**
     * Get a list of all entities
     *
     * Get a list of all entities
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void seeEntitiesTest() throws ApiException {
        api.seeEntities();

        // TODO: test validations
    }
    
}
