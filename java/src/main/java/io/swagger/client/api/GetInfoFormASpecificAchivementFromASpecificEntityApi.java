

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

public class GetInfoFormASpecificAchivementFromASpecificEntityApi {
    private ApiClient apiClient;

    public GetInfoFormASpecificAchivementFromASpecificEntityApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GetInfoFormASpecificAchivementFromASpecificEntityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for searchSpecificAchivement
     * @param idEntity Id of entity (required)
     * @param name Id of leaderboard (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call searchSpecificAchivementCall(Integer idEntity, Integer name, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/entity/{id_entity}/achievements/{name}"
            .replaceAll("\\{" + "id_entity" + "\\}", apiClient.escapeString(idEntity.toString()))
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

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
    private com.squareup.okhttp.Call searchSpecificAchivementValidateBeforeCall(Integer idEntity, Integer name, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'idEntity' is set
        if (idEntity == null) {
            throw new ApiException("Missing the required parameter 'idEntity' when calling searchSpecificAchivement(Async)");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling searchSpecificAchivement(Async)");
        }
        

        com.squareup.okhttp.Call call = searchSpecificAchivementCall(idEntity, name, progressListener, progressRequestListener);
        return call;

    }

    /**
     * 
     * Get info form a specific achivement from a specific entity 
     * @param idEntity Id of entity (required)
     * @param name Id of leaderboard (required)
     * @return List&lt;Entity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Entity> searchSpecificAchivement(Integer idEntity, Integer name) throws ApiException {
        ApiResponse<List<Entity>> resp = searchSpecificAchivementWithHttpInfo(idEntity, name);
        return resp.getData();
    }

    /**
     * 
     * Get info form a specific achivement from a specific entity 
     * @param idEntity Id of entity (required)
     * @param name Id of leaderboard (required)
     * @return ApiResponse&lt;List&lt;Entity&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Entity>> searchSpecificAchivementWithHttpInfo(Integer idEntity, Integer name) throws ApiException {
        com.squareup.okhttp.Call call = searchSpecificAchivementValidateBeforeCall(idEntity, name, null, null);
        Type localVarReturnType = new TypeToken<List<Entity>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get info form a specific achivement from a specific entity 
     * @param idEntity Id of entity (required)
     * @param name Id of leaderboard (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchSpecificAchivementAsync(Integer idEntity, Integer name, final ApiCallback<List<Entity>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchSpecificAchivementValidateBeforeCall(idEntity, name, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Entity>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for searchSpecificAchivement22
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @param achievements Id of leaderboard (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call searchSpecificAchivement22Call(Integer idEntity, Integer idPlayer, Integer achievements, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/entity/{id_entity}/achievements/{achievements}/players/{id_player}"
            .replaceAll("\\{" + "id_entity" + "\\}", apiClient.escapeString(idEntity.toString()))
            .replaceAll("\\{" + "id_player" + "\\}", apiClient.escapeString(idPlayer.toString()))
            .replaceAll("\\{" + "achievements" + "\\}", apiClient.escapeString(achievements.toString()));

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
    private com.squareup.okhttp.Call searchSpecificAchivement22ValidateBeforeCall(Integer idEntity, Integer idPlayer, Integer achievements, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'idEntity' is set
        if (idEntity == null) {
            throw new ApiException("Missing the required parameter 'idEntity' when calling searchSpecificAchivement22(Async)");
        }
        
        // verify the required parameter 'idPlayer' is set
        if (idPlayer == null) {
            throw new ApiException("Missing the required parameter 'idPlayer' when calling searchSpecificAchivement22(Async)");
        }
        
        // verify the required parameter 'achievements' is set
        if (achievements == null) {
            throw new ApiException("Missing the required parameter 'achievements' when calling searchSpecificAchivement22(Async)");
        }
        

        com.squareup.okhttp.Call call = searchSpecificAchivement22Call(idEntity, idPlayer, achievements, progressListener, progressRequestListener);
        return call;

    }

    /**
     * 
     * Get info form a specific achivement from a specific entity 
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @param achievements Id of leaderboard (required)
     * @return List&lt;Entity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Entity> searchSpecificAchivement22(Integer idEntity, Integer idPlayer, Integer achievements) throws ApiException {
        ApiResponse<List<Entity>> resp = searchSpecificAchivement22WithHttpInfo(idEntity, idPlayer, achievements);
        return resp.getData();
    }

    /**
     * 
     * Get info form a specific achivement from a specific entity 
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @param achievements Id of leaderboard (required)
     * @return ApiResponse&lt;List&lt;Entity&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Entity>> searchSpecificAchivement22WithHttpInfo(Integer idEntity, Integer idPlayer, Integer achievements) throws ApiException {
        com.squareup.okhttp.Call call = searchSpecificAchivement22ValidateBeforeCall(idEntity, idPlayer, achievements, null, null);
        Type localVarReturnType = new TypeToken<List<Entity>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get info form a specific achivement from a specific entity 
     * @param idEntity Id of entity (required)
     * @param idPlayer Id of leaderboard (required)
     * @param achievements Id of leaderboard (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchSpecificAchivement22Async(Integer idEntity, Integer idPlayer, Integer achievements, final ApiCallback<List<Entity>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchSpecificAchivement22ValidateBeforeCall(idEntity, idPlayer, achievements, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Entity>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
