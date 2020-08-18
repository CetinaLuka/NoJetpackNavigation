package com.i.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onNavigateListener {
    val homeFragment = HomeFragment()
    val fragment2 = Fragment2()
    val fragment3 = Fragment3()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(fragment_container != null){
            if (savedInstanceState != null) {
                return;
            }
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, homeFragment).commit()
        }
    }
    fun navigateToFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
    override fun onNavigate(fragmentPosition: Int) {
        if(fragmentPosition==1){
            navigateToFragment(homeFragment)
        }
        else if(fragmentPosition==2){
            navigateToFragment(fragment2)
        }
        else{
            navigateToFragment(fragment3)
        }
    }
}