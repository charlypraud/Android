package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TP5 : AppCompatActivity() {

    private  val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item->
        when(item.itemId) {
            R.id.nav_home -> {
                replaceFragment(fragment_1())
                saveLastItem(R.id.nav_home)
                saveLastFragment("fragment 1")
                true
            }
            R.id.nav_plane -> {
                replaceFragment(fragment_2())
                saveLastItem(R.id.nav_plane)
                saveLastFragment("fragment 2")
                true
            }
            R.id.nav_taxi -> {
                replaceFragment(fragment_3())
                saveLastItem(R.id.nav_taxi)
                saveLastFragment("fragment 3")
                true
            }
            else -> false
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p4)

        var bottomNav: BottomNavigationView = findViewById(R.id.btm_nav_bar)
        val lastItem: Int = getLastItem()
        val lastFragment: Fragment = getLastFragment()

        bottomNav.selectedItemId = lastItem
        replaceFragment(lastFragment)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framgent_container, fragment)
        fragmentTransaction.commit()
    }

    private fun saveLastItem(itemSaved: Int) {
        val preferences = this.getSharedPreferences("save_tp5", MODE_PRIVATE)
        preferences.edit().putInt("item", itemSaved).apply()
    }

    private fun saveLastFragment(fragmentSaved: String) {
        val preferences = this.getSharedPreferences("save_tp5", MODE_PRIVATE)
        preferences.edit().putString("fragment", fragmentSaved).apply()
    }

    private fun getLastItem(): Int {
        val preferences = this.getSharedPreferences("save_tp5", MODE_PRIVATE)
        val lastItem =  preferences.getInt("item", -1)
        return lastItem
    }

    private fun getLastFragment(): Fragment {
        val preferences = this.getSharedPreferences("save_tp5", MODE_PRIVATE)
        val lastFragment =  preferences.getString("fragment", "defaut")
        val response: Fragment
        when(lastFragment) {
            "fragment 1" -> {
                response = fragment_1()
            }
            "fragment 2" -> {
                response = fragment_2()
            }
            "fragment 3" -> {
                response = fragment_3()
            }
            //Fragment de base au démarrage
            else -> response = fragment_1()
        }
       return response
    }
}

