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
 * API tests for GetInfoFormASpecificEntityApi
 */
@Ignore
public class GetInfoFormASpecificEntityApiTest {

    private final GetInfoFormASpecificEntityApi api = new GetInfoFormASpecificEntityApi();

    
    /**
     * Get a info of one entity
     *
     * Get info of one entity 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSpecificEntitieTest() throws ApiException {
        Integer idEntity = null;
        List<Entity> response = api.searchSpecificEntitie(idEntity);

        // TODO: test validations
    }
    
}
