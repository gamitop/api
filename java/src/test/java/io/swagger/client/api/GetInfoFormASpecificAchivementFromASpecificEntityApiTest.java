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
 * API tests for GetInfoFormASpecificAchivementFromASpecificEntityApi
 */
@Ignore
public class GetInfoFormASpecificAchivementFromASpecificEntityApiTest {

    private final GetInfoFormASpecificAchivementFromASpecificEntityApi api = new GetInfoFormASpecificAchivementFromASpecificEntityApi();

    
    /**
     * 
     *
     * Get info form a specific achivement from a specific entity 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSpecificAchivementTest() throws ApiException {
        Integer idEntity = null;
        Integer name = null;
        List<Entity> response = api.searchSpecificAchivement(idEntity, name);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Get info form a specific achivement from a specific entity 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSpecificAchivement22Test() throws ApiException {
        Integer idEntity = null;
        Integer idPlayer = null;
        Integer achievements = null;
        List<Entity> response = api.searchSpecificAchivement22(idEntity, idPlayer, achievements);

        // TODO: test validations
    }
    
}
