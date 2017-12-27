package io.swagger.client.api;

import io.swagger.client.ApiException;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DeleteASpecificEntityApi
 */
@Ignore
public class DeleteASpecificEntityApiTest {

    private final DeleteASpecificEntityApi api = new DeleteASpecificEntityApi();

    
    /**
     * delete entity
     *
     * Delete a entity
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteEntityTest() throws ApiException {
        Integer idEntity = null;
        api.deleteEntity(idEntity);

        // TODO: test validations
    }
    
}
