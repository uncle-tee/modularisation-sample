package ng.com.dcodes.furnitureapp.network.di


import dagger.Binds
import dagger.Module
import ng.com.dcodes.furnitureapp.network.catalogue.CatalogueRemote
import ng.com.dcodes.furnitureapp.network.catalogue.CatalogueRemoteImpl
import javax.inject.Singleton


@Module
abstract class NetworkModule{


    @Binds
    @Singleton
    abstract fun bindCatalogueRemote(catalogueRemoteImpl: CatalogueRemoteImpl): CatalogueRemote
}