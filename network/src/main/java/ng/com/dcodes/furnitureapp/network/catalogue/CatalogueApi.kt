package ng.com.dcodes.furnitureapp.network.catalogue

import retrofit2.http.GET

interface CatalogueApi {

    @GET("catalogue")
    suspend fun getAllCatalohues(): Any
}