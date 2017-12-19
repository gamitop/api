# DevelopersApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchEntities**](DevelopersApi.md#searchEntities) | **GET** /entity | Get a list of all entities


<a name="searchEntities"></a>
# **searchEntities**
> List&lt;Entity&gt; searchEntities()

Get a list of all entities

Get a list of all entities 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DevelopersApi;


DevelopersApi apiInstance = new DevelopersApi();
try {
    List<Entity> result = apiInstance.searchEntities();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevelopersApi#searchEntities");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Entity&gt;**](Entity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, /xml

