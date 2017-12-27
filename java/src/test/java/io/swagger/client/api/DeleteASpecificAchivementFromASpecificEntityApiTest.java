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
 * API tests for DeleteASpecificAchivementFromASpecificEntityApi
 */
@Ignore
public class DeleteASpecificAchivementFromASpecificEntityApiTest {

    private final DeleteASpecificAchivementFromASpecificEntityApi api = new DeleteASpecificAchivementFromASpecificEntityApi();

    
    /**
     * delete achivement
     *
     * Delete a achivement
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteAchivementTest() throws ApiException {
        Entity deleteAchivment = null;
        api.deleteAchivement(deleteAchivment);

        // TODO: test validations
    }
    
}
