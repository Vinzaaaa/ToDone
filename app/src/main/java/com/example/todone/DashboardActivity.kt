package com.example.todone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todone.databinding.ActivityDashboard2Binding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboard2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboard2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Dashboard())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.dashboard -> replaceFragment(Dashboard())
                R.id.home -> replaceFragment(Home())
                R.id.calc -> replaceFragment(Calculator())
                R.id.profile -> replaceFragment(Profile())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_dash,fragment)
        fragmentTransaction.commit()
    }
}