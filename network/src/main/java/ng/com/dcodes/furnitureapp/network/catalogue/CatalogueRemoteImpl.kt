package ng.com.dcodes.furnitureapp.network.catalogue

import android.content.Context
import ng.com.dcodes.furnitureapp.network.R
import ng.com.dcodes.furnitureapp.network.R.string.base_url
import ng.com.dcodes.furnitureapp.network.RemoteSourceConfig
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatalogueRemoteImpl @Inject constructor(context: Context)
    : RemoteSourceConfig<CatalogueApi>(context,CatalogueApi::class.java), CatalogueRemote{

    override suspend fun  getAllCatalogues(){
        try{
            api.getAllCatalohues()
        }catch (exception: Exception){
            throw exception
        }
    }


    override fun testingData() = context.getString(base_url)


}