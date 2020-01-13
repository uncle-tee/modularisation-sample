package ng.com.dcodes.furnitureapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(setOf(R.id.nav_home)).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btmNavMain = findViewById<BottomNavigationView>(R.id.btm_nav_main)

        btmNavMain.setupWithNavController(navController)
        //  setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
