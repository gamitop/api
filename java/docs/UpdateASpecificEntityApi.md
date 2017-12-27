# UpdateASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateEntity**](UpdateASpecificEntityApi.md#updateEntity) | **PUT** /entity/{id_entity} | update entity


<a name="updateEntity"></a>
# **updateEntity**
> updateEntity(updateEntity)

update entity

Update info from an entity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpdateASpecificEntityApi;


UpdateASpecificEntityApi apiInstance = new UpdateASpecificEntityApi();
Entity updateEntity = new Entity(); // Entity | Update Entity
try {
    apiInstance.updateEntity(updateEntity);
} catch (ApiException e) {
    System.err.println("Exception when calling UpdateASpecificEntityApi#updateEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateEntity** | [**Entity**](Entity.md)| Update Entity | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

