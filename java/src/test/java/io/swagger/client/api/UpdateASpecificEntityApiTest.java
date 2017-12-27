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
 * API tests for UpdateASpecificEntityApi
 */
@Ignore
public class UpdateASpecificEntityApiTest {

    private final UpdateASpecificEntityApi api = new UpdateASpecificEntityApi();

    
    /**
     * update entity
     *
     * Update info from an entity
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateEntityTest() throws ApiException {
        Entity updateEntity = null;
        api.updateEntity(updateEntity);

        // TODO: test validations
    }
    
}
