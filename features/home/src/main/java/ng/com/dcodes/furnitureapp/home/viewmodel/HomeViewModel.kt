package ng.com.dcodes.home.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ng.com.dcodes.domain.dao.UserDao
import ng.com.dcodes.domain.entities.User
import javax.inject.Inject


class HomeViewModel @Inject constructor(userDao: UserDao) : ViewModel() {

     val user: LiveData<String> = Transformations.map(userDao.findLatest()){
          it?.name?:"Empty User for now"
     }



}