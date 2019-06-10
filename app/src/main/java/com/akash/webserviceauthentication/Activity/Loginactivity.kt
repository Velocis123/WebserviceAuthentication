
package com.akash.webserviceauthentication.Activity

import android.app.DownloadManager
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.akash.webserviceauthentication.R
import com.akash.webserviceauthentication.Util.SharedPrefManager
import com.akash.webserviceauthentication.Util.URLs
import com.akash.webserviceauthentication.Util.VolleySingleton
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_loginactivity.*
import org.json.JSONObject
import java.lang.reflect.Method


class Loginactivity : AppCompatActivity() {
private var password:String?=""
    private var username:String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)
        var  sharedPrefManager = SharedPrefManager(this)
        if (sharedPrefManager.getInstance(this).isLoggedIn()){

            finish()
            this!!.startActivity(Intent(this, Registeractivity::class.java))


        }
btn_register.setOnClickListener {
    if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){

        Toast.makeText(this,"All Fields Must be filled First",Toast.LENGTH_SHORT).show()

    }else{


        userLogin()
    }


}

        btn_register.setOnClickListener {

            finish()
            startActivity(Intent(applicationContext, Registeractivity::class.java))


        }



    }
    private fun userLogin(){


 username = edt_login_email.text.toString()
         password = edt_login_pass.text.toString()
        var url: URLs? = null
        val params = HashMap<String,String>()
        params["username"] = "username"
        params["password"] = "password"
        val jsonObject = JSONObject(params)

        // Volley post request with parameters
        val request = JsonObjectRequest(Request.Method.POST,url!!.URL_LOGIN,jsonObject,
            Response.Listener { response ->
                // Process the json
                this!!.startActivity(Intent(this, MainActivity::class.java))

            }, Response.ErrorListener{

                // Error in request
                Log.d("Log in Error","Error While logging in")
               // textView.text = "Volley error: $it"
            })

//        var stringRequest = StringRequest(Request.Method.POST)
//
//
//
//            Toast.makeText(this,"Registration Sucessfull",Toast.LENGTH_SHORT).show()
//            this!!.startActivity(Intent(this, MainActivity::class.java))
//
//
//
//        },Response.ErrorListener {
//                error ->
//
//            Log.d("Log in Error","Error While logging in")
//
//        })
//       {





        var volleySingleton:VolleySingleton?=null
        volleySingleton!!.getInstance(this).addToRequestQueue(request)

    }
}
