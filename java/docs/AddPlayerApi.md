# AddPlayerApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPlayer**](AddPlayerApi.md#addPlayer) | **POST** /entity/{id_entity}/leaderboards/{id_leaderboard}/players | add player


<a name="addPlayer"></a>
# **addPlayer**
> addPlayer(newPlayer)

add player

Add players to leaderboards

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AddPlayerApi;


AddPlayerApi apiInstance = new AddPlayerApi();
Leaderboard newPlayer = new Leaderboard(); // Leaderboard | Add new Player
try {
    apiInstance.addPlayer(newPlayer);
} catch (ApiException e) {
    System.err.println("Exception when calling AddPlayerApi#addPlayer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newPlayer** | [**Leaderboard**](Leaderboard.md)| Add new Player | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, text/xml

