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
 * API tests for AddAchivementToASpecificEntityApi
 */
@Ignore
public class AddAchivementToASpecificEntityApiTest {

    private final AddAchivementToASpecificEntityApi api = new AddAchivementToASpecificEntityApi();

    
    /**
     * add achivement to a specific entity
     *
     * Add achivements to one entity
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addAchivementTest() throws ApiException {
        Entity newAchivement = null;
        api.addAchivement(newAchivement);

        // TODO: test validations
    }
    
}
