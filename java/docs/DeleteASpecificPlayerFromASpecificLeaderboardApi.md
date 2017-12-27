# DeleteASpecificPlayerFromASpecificLeaderboardApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePlayer**](DeleteASpecificPlayerFromASpecificLeaderboardApi.md#deletePlayer) | **DELETE** /entity/{id_entity}/leaderboards/{id_leaderboard}/players/{id_player} | delete player


<a name="deletePlayer"></a>
# **deletePlayer**
> deletePlayer(deletePlayer)

delete player

Delete a player

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DeleteASpecificPlayerFromASpecificLeaderboardApi;


DeleteASpecificPlayerFromASpecificLeaderboardApi apiInstance = new DeleteASpecificPlayerFromASpecificLeaderboardApi();
Leaderboard deletePlayer = new Leaderboard(); // Leaderboard | Delete Player
try {
    apiInstance.deletePlayer(deletePlayer);
} catch (ApiException e) {
    System.err.println("Exception when calling DeleteASpecificPlayerFromASpecificLeaderboardApi#deletePlayer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deletePlayer** | [**Leaderboard**](Leaderboard.md)| Delete Player | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

