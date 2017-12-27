# GetInfoFormASpecificPlayerFromASpecificLeaderboardApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchSpecificPlayer**](GetInfoFormASpecificPlayerFromASpecificLeaderboardApi.md#searchSpecificPlayer) | **GET** /entity/{id_entity}/leaderboards/{id_leaderboard}/players/{id_player} | 


<a name="searchSpecificPlayer"></a>
# **searchSpecificPlayer**
> List&lt;Leaderboard&gt; searchSpecificPlayer(idEntity, idLeaderboard, idPlayer)



Get info form a specific player from a specific leaderboard 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetInfoFormASpecificPlayerFromASpecificLeaderboardApi;


GetInfoFormASpecificPlayerFromASpecificLeaderboardApi apiInstance = new GetInfoFormASpecificPlayerFromASpecificLeaderboardApi();
Integer idEntity = 56; // Integer | Id of entity
Integer idLeaderboard = 56; // Integer | Id of leaderboard
Integer idPlayer = 56; // Integer | Id of leaderboard
try {
    List<Leaderboard> result = apiInstance.searchSpecificPlayer(idEntity, idLeaderboard, idPlayer);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetInfoFormASpecificPlayerFromASpecificLeaderboardApi#searchSpecificPlayer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |
 **idLeaderboard** | **Integer**| Id of leaderboard |
 **idPlayer** | **Integer**| Id of leaderboard |

### Return type

[**List&lt;Leaderboard&gt;**](Leaderboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

