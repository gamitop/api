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
 * API tests for AddEntityApi
 */
@Ignore
public class AddEntityApiTest {

    private final AddEntityApi api = new AddEntityApi();

    
    /**
     * add entities
     *
     * Add entities(users) to the system
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addEntityTest() throws ApiException {
        Entity newEntity = null;
        api.addEntity(newEntity);

        // TODO: test validations
    }
    
}
