package pe.upc.com.catchup.viewcontroller.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import pe.upc.com.catchup.R
import pe.upc.com.catchup.viewcontroller.fragments.FavoritesFragment
import pe.upc.com.catchup.viewcontroller.fragments.HomeFragment
import pe.upc.com.catchup.viewcontroller.fragments.SettingsFragment
import pe.upc.com.catchup.viewcontroller.fragments.SourcesFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        return@OnNavigationItemSelectedListener navigateTO(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun fragmentFor(item:MenuItem):android.support.v4.app.Fragment{
        when(item.itemId){
            R.id.navigation_home->{
                return HomeFragment()
            }
            R.id.navigation_sources -> {
                return SourcesFragment()
            }
            R.id.navigation_favorites -> {
                return FavoritesFragment()
            }
            R.id.navigation_settings -> {
                return SettingsFragment()
            }
        }
        return HomeFragment()
    }

    private fun navigateTO(item:MenuItem):Boolean{
        item.setChecked(true)
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragmentFor(item))
                .commit() > 0
    }
}
