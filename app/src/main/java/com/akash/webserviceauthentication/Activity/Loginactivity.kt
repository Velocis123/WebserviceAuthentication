
package com.akash.webserviceauthentication.Activity

import android.app.DownloadManager
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
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
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_loginactivity.*
import org.json.JSONObject
import java.lang.reflect.Method


class Loginactivity : AppCompatActivity() {
private lateinit var password:String
    private lateinit var username:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_loginactivity)
        var  sharedPrefManager = SharedPrefManager(this)
        if (sharedPrefManager.getInstance(this).isLoggedIn()){

            finish()
            this.startActivity(Intent(this, Registeractivity::class.java))


        }
btn_login.setOnClickListener {
//    if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
//
//        Toast.makeText(this,"All Fields Must be filled First",Toast.LENGTH_SHORT).show()
//
//    }else{
//
//
//        userLogin()
//    }

    userLogin()
}

        btn_register.setOnClickListener {

            finish()
            startActivity(Intent(applicationContext, Registeractivity::class.java))


        }



    }
    private fun userLogin(){

        var user = findViewById<EditText>(R.id.edt_login_email)
        var pass = findViewById<EditText>(R.id.edt_login_pass)
        username = user.text.toString()
         password = pass.text.toString()
        var url= URLs()
        val params = HashMap<String,String>()
        params["username"] = username
        params["password"] = password



        val jsonObject = JSONObject(params)

        var progressDialog:ProgressDialog= ProgressDialog.show(this,"Login","Login")


        // Volley post request with parameters
        val request = JsonObjectRequest(Request.Method.POST,url.URL_LOGIN,jsonObject,
            Response.Listener {
                // Process the json
                Toast.makeText(this,username+password,Toast.LENGTH_LONG).show()
                progressDialog.dismiss()

                var sharedPreferences:SharedPreferences = this.getSharedPreferences("volleyregisterlogin", Context.MODE_PRIVATE)
                var editor:SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("keyusername", username)
                editor.commit()


                startActivity(Intent(this, MainActivity::class.java))
                finish()

            }, Response.ErrorListener{
error->

                // Error in request
                progressDialog.dismiss()
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
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





        /*var volleySingleton:VolleySingleton= VolleySingleton(this)
        volleySingleton.getInstance(this).addToRequestQueue(request)*/

        Volley.newRequestQueue(this).add(request)

    }
}
