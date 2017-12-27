# UpdateaSpecificAchivementFromASpecificEntityApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateAchivement**](UpdateaSpecificAchivementFromASpecificEntityApi.md#updateAchivement) | **PUT** /entity/{id_entity}/achievements/{name} | update achivement


<a name="updateAchivement"></a>
# **updateAchivement**
> updateAchivement(updateAchivemnt)

update achivement

Update info from a achivement

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpdateaSpecificAchivementFromASpecificEntityApi;


UpdateaSpecificAchivementFromASpecificEntityApi apiInstance = new UpdateaSpecificAchivementFromASpecificEntityApi();
Entity updateAchivemnt = new Entity(); // Entity | Update Achivement
try {
    apiInstance.updateAchivement(updateAchivemnt);
} catch (ApiException e) {
    System.err.println("Exception when calling UpdateaSpecificAchivementFromASpecificEntityApi#updateAchivement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateAchivemnt** | [**Entity**](Entity.md)| Update Achivement | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

