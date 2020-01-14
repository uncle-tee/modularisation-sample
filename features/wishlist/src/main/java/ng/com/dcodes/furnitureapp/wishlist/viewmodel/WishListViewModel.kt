package ng.com.dcodes.furnitureapp.wishlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ng.com.dcodes.domain.entities.User
import ng.com.dcodes.furnitureapp.domain.dao.UserDao
import ng.com.dcodes.mobile.common.utils.UiState
import javax.inject.Inject

class WishListViewModel @Inject constructor(private val userDao: UserDao) : ViewModel() {

    private val viewModelJob = Job()
    private val uiCoroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val user: MutableLiveData<String> = MutableLiveData()
    private val  _uistate : MutableLiveData<UiState> = MutableLiveData()
    val uiState: LiveData<UiState> = _uistate


    fun saveUser(){
        val newUser = User(name = user.value!!)
        uiCoroutineScope.launch {
            insertUser(newUser)
            _uistate.postValue(UiState.Complete)
        }


    }


    suspend fun  insertUser(user: User){
        withContext(Dispatchers.IO){
            return@withContext  userDao.insert(user)
        }
    }
}