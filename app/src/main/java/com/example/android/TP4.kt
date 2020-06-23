package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TP4 : AppCompatActivity() {

    private  val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item->
        when(item.itemId) {
            R.id.nav_home -> {
                replaceFragment(fragment_1())
                true
            }
            R.id.nav_plane -> {
                replaceFragment(fragment_2())
                true
            }
            R.id.nav_taxi -> {
                replaceFragment(fragment_3())
                true
            }
            else -> false
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p4)

        var bottomNav: BottomNavigationView = findViewById(R.id.btm_nav_bar)

        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(fragment_1())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framgent_container, fragment)
        fragmentTransaction.commit()
    }
}

