package ng.com.dcodes.furnitureapp.network.catalogue

interface CatalogueRemote {

    suspend  fun getAllCatalogues()

    fun testingData(): String
}