package com.akash.webserviceauthentication.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.akash.webserviceauthentication.R
import com.akash.webserviceauthentication.Util.SharedPrefManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var sharedPrefManager = SharedPrefManager(this)
        if (sharedPrefManager.getInstance(this).isLoggedIn()){

            txt_home.text="Welcome To the Home Screen!"




        }else{

            this.startActivity(Intent(this, Loginactivity::class.java))
            finish()


        }



    }
}
