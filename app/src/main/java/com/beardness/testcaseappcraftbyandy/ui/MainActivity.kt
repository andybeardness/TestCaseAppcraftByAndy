package com.beardness.testcaseappcraftbyandy.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.beardness.testcaseappcraftbyandy.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickGoToNetwork(view: View) {
        val intent = Intent(this@MainActivity, NetworkActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoToDatabase(view: View) {
        val intent = Intent(this@MainActivity, DatabaseActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoToService(view: View) {
        val intent = Intent(this@MainActivity, ServiceActivity::class.java)
        startActivity(intent)
    }

}