# GetLeaderboardFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**seeLeaderboardsFromSepcifficEntity**](GetLeaderboardFromASpecificEntityApi.md#seeLeaderboardsFromSepcifficEntity) | **GET** /entity/{id_entity}/leaderboards | Get leaderboard from a specific entity


<a name="seeLeaderboardsFromSepcifficEntity"></a>
# **seeLeaderboardsFromSepcifficEntity**
> List&lt;Entity&gt; seeLeaderboardsFromSepcifficEntity(idEntity)

Get leaderboard from a specific entity

Get leaderboard from a specific entity 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetLeaderboardFromASpecificEntityApi;


GetLeaderboardFromASpecificEntityApi apiInstance = new GetLeaderboardFromASpecificEntityApi();
Integer idEntity = 56; // Integer | Id of entity
try {
    List<Entity> result = apiInstance.seeLeaderboardsFromSepcifficEntity(idEntity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetLeaderboardFromASpecificEntityApi#seeLeaderboardsFromSepcifficEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |

### Return type

[**List&lt;Entity&gt;**](Entity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

