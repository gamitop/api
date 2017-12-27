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
 * API tests for UpdateaSpecificAchivementFromASpecificEntityApi
 */
@Ignore
public class UpdateaSpecificAchivementFromASpecificEntityApiTest {

    private final UpdateaSpecificAchivementFromASpecificEntityApi api = new UpdateaSpecificAchivementFromASpecificEntityApi();

    
    /**
     * update achivement
     *
     * Update info from a achivement
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateAchivementTest() throws ApiException {
        Entity updateAchivemnt = null;
        api.updateAchivement(updateAchivemnt);

        // TODO: test validations
    }
    
}
