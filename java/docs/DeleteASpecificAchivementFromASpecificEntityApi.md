# DeleteASpecificAchivementFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteAchivement**](DeleteASpecificAchivementFromASpecificEntityApi.md#deleteAchivement) | **DELETE** /entity/{id_entity}/achievements/{name} | delete achivement


<a name="deleteAchivement"></a>
# **deleteAchivement**
> deleteAchivement(deleteAchivment)

delete achivement

Delete a achivement

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DeleteASpecificAchivementFromASpecificEntityApi;


DeleteASpecificAchivementFromASpecificEntityApi apiInstance = new DeleteASpecificAchivementFromASpecificEntityApi();
Entity deleteAchivment = new Entity(); // Entity | Delete Achivement
try {
    apiInstance.deleteAchivement(deleteAchivment);
} catch (ApiException e) {
    System.err.println("Exception when calling DeleteASpecificAchivementFromASpecificEntityApi#deleteAchivement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteAchivment** | [**Entity**](Entity.md)| Delete Achivement | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

