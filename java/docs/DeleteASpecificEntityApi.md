# DeleteASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEntity**](DeleteASpecificEntityApi.md#deleteEntity) | **DELETE** /entity/{id_entity} | delete entity


<a name="deleteEntity"></a>
# **deleteEntity**
> deleteEntity(idEntity)

delete entity

Delete a entity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DeleteASpecificEntityApi;


DeleteASpecificEntityApi apiInstance = new DeleteASpecificEntityApi();
Integer idEntity = 56; // Integer | Id of entity
try {
    apiInstance.deleteEntity(idEntity);
} catch (ApiException e) {
    System.err.println("Exception when calling DeleteASpecificEntityApi#deleteEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

