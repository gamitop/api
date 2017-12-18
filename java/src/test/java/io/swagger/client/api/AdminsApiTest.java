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
 * API tests for AdminsApi
 */
@Ignore
public class AdminsApiTest {

    private final AdminsApi api = new AdminsApi();

    
    /**
     * add an inventory item
     *
     * Adds an item to the system
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addInventoryTest() throws ApiException {
        Entity newEntity = null;
        api.addInventory(newEntity);

        // TODO: test validations
    }
    
}
