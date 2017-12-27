# GetEntitiesApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**seeEntities**](GetEntitiesApi.md#seeEntities) | **GET** /entity | Get a list of all entities


<a name="seeEntities"></a>
# **seeEntities**
> seeEntities()

Get a list of all entities

Get a list of all entities

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetEntitiesApi;


GetEntitiesApi apiInstance = new GetEntitiesApi();
try {
    apiInstance.seeEntities();
} catch (ApiException e) {
    System.err.println("Exception when calling GetEntitiesApi#seeEntities");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

