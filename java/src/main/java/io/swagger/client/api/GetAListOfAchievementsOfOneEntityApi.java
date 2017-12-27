

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Entity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAListOfAchievementsOfOneEntityApi {
    private ApiClient apiClient;

    public GetAListOfAchievementsOfOneEntityApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GetAListOfAchievementsOfOneEntityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for seeAchivementsFromSpecificEntity
     * @param idEntity Id of entity (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call seeAchivementsFromSpecificEntityCall(Integer idEntity, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/entity/{id_entity}/achievements"
            .replaceAll("\\{" + "id_entity" + "\\}", apiClient.escapeString(idEntity.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "text/xml"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call seeAchivementsFromSpecificEntityValidateBeforeCall(Integer idEntity, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'idEntity' is set
        if (idEntity == null) {
            throw new ApiException("Missing the required parameter 'idEntity' when calling seeAchivementsFromSpecificEntity(Async)");
        }
        

        com.squareup.okhttp.Call call = seeAchivementsFromSpecificEntityCall(idEntity, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a list of achievements of one entity
     * Get a list of achievements of one entity 
     * @param idEntity Id of entity (required)
     * @return List&lt;Entity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Entity> seeAchivementsFromSpecificEntity(Integer idEntity) throws ApiException {
        ApiResponse<List<Entity>> resp = seeAchivementsFromSpecificEntityWithHttpInfo(idEntity);
        return resp.getData();
    }

    /**
     * Get a list of achievements of one entity
     * Get a list of achievements of one entity 
     * @param idEntity Id of entity (required)
     * @return ApiResponse&lt;List&lt;Entity&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Entity>> seeAchivementsFromSpecificEntityWithHttpInfo(Integer idEntity) throws ApiException {
        com.squareup.okhttp.Call call = seeAchivementsFromSpecificEntityValidateBeforeCall(idEntity, null, null);
        Type localVarReturnType = new TypeToken<List<Entity>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of achievements of one entity (asynchronously)
     * Get a list of achievements of one entity 
     * @param idEntity Id of entity (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call seeAchivementsFromSpecificEntityAsync(Integer idEntity, final ApiCallback<List<Entity>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = seeAchivementsFromSpecificEntityValidateBeforeCall(idEntity, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Entity>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
