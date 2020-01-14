package ng.com.dcodes.furnitureapp.wishlist.presenter


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ng.com.dcodes.furnitureapp.core.FurnitureApp
import ng.com.dcodes.furnitureapp.wishlist.R
import ng.com.dcodes.furnitureapp.wishlist.databinding.FragmentWishlistBinding
import ng.com.dcodes.furnitureapp.wishlist.di.DaggerWishlistComponent
import ng.com.dcodes.furnitureapp.wishlist.viewmodel.WishListViewModel
import ng.com.dcodes.mobile.common.utils.UiState
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WishlistFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val wishListViewModel: WishListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(WishListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWishlistBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_wishlist, container, false)
        binding.lifecycleOwner = this
        binding.data = wishListViewModel

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                   }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                    }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                wishListViewModel.user.value = s?.toString()
            }

        })

        wishListViewModel.uiState.observe(this, Observer {
            when(it){
               is UiState.Complete -> {
                    Toast.makeText(this@WishlistFragment.activity!!.applicationContext, "Successfully saved",Toast.LENGTH_LONG ).show()
                }
            }
        })
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val coreComponent = (activity!!.applicationContext as FurnitureApp).coreComponent

        DaggerWishlistComponent.factory()
            .create(coreComponent)
            .inject(this)




    }


}
