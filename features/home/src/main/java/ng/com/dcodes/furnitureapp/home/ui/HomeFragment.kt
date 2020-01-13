package ng.com.dcodes.home.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ng.com.dcodes.common.viewmodelUtils.ViewModelFactory
import ng.com.dcodes.core.FunitureApp
import ng.com.dcodes.domain.conf.FurnitureDatabase
import ng.com.dcodes.domain.dao.UserDao


import ng.com.dcodes.home.R
import ng.com.dcodes.home.databinding.FragmentHomeBinding
import ng.com.dcodes.home.di.DaggerHomeComponent
import ng.com.dcodes.home.viewmodel.HomeViewModel
import ng.com.dcodes.network.Catalogue.CatalogueRemote
import ng.com.dcodes.network.Catalogue.CatalogueRemoteImpl
import ng.com.dcodes.network.Catalogue.CatalogueRemoteImpl_Factory

import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    val homeViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false )
        binding.lifecycleOwner = this
        binding.data = homeViewModel
        return binding.root
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)

        val coreComponent = (activity!!.applicationContext as FunitureApp).coreComponent

        DaggerHomeComponent.factory()
            .create(coreComponent)
            .inject(this)




    }


}
