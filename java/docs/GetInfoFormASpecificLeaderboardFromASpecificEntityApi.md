# GetInfoFormASpecificLeaderboardFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchSpecificLeaderboard**](GetInfoFormASpecificLeaderboardFromASpecificEntityApi.md#searchSpecificLeaderboard) | **GET** /entity/{id_entity}/leaderboards/{id_leaderboard} | Get info form a specific leaderboard from a specific entity


<a name="searchSpecificLeaderboard"></a>
# **searchSpecificLeaderboard**
> List&lt;Entity&gt; searchSpecificLeaderboard(idEntity, idLeaderboard)

Get info form a specific leaderboard from a specific entity

Get info form a specific leaderboard from a specific entity 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetInfoFormASpecificLeaderboardFromASpecificEntityApi;


GetInfoFormASpecificLeaderboardFromASpecificEntityApi apiInstance = new GetInfoFormASpecificLeaderboardFromASpecificEntityApi();
Integer idEntity = 56; // Integer | Id of entity
Integer idLeaderboard = 56; // Integer | Id of leaderboard
try {
    List<Entity> result = apiInstance.searchSpecificLeaderboard(idEntity, idLeaderboard);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetInfoFormASpecificLeaderboardFromASpecificEntityApi#searchSpecificLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |
 **idLeaderboard** | **Integer**| Id of leaderboard |

### Return type

[**List&lt;Entity&gt;**](Entity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

