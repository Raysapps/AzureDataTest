package com.temp.azuredatatest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azure.data.AzureData
import com.azure.data.model.PermissionMode
import java.lang.Exception

class MainViewModel:ViewModel() {

    // AzureData.getDocument() return status : Success or Failed
    val cosmosCallStatus = MutableLiveData<String>()
    // error message
    val cosmosCause = MutableLiveData<String>() //
    // json outputz
    val fetchData = MutableLiveData<String>()

    fun fetch()
    {
        try {


            // Add Valid Document, Collection, DataBase ID
            var documentID = ""
            var collectionID = ""
            var databaseID = ""
            AzureData.getDocument(
                documentID,
                documentID,
                collectionID,
                databaseID,
                TestDocument::class.java
            )
            {
                if (it.isSuccessful) {
                    fetchData.postValue(it.jsonData)
                    cosmosCallStatus.postValue("Success")

                } else {
                    fetchData.postValue(it.error?.code)
                    cosmosCallStatus.postValue("Failed")
                    cosmosCause.postValue(it.error?.message)
                }

            }
        }
        catch(e:Exception)
        {
            cosmosCallStatus.postValue("Failed")
            cosmosCause.postValue(e.message)
        }
    }

}