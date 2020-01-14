package ng.com.dcodes.home.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ng.com.dcodes.furnitureapp.domain.dao.UserDao
import javax.inject.Inject


class HomeViewModel @Inject constructor(userDao: UserDao) : ViewModel() {

     val user: LiveData<String> = Transformations.map(userDao.findLatest()){
          it?.name?:"Empty User for now"
     }



}