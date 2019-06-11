package com.akash.webserviceauthentication.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.akash.webserviceauthentication.R
import com.akash.webserviceauthentication.Util.SharedPrefManager
import com.akash.webserviceauthentication.Util.URLs
import com.akash.webserviceauthentication.Util.VolleySingleton
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_loginactivity.*
import kotlinx.android.synthetic.main.activity_loginactivity.btn_register
import kotlinx.android.synthetic.main.activity_registeractivity.*
import org.json.JSONObject

class Registeractivity : AppCompatActivity() {
lateinit var username :String
  lateinit  var  password :String
   lateinit var email:String
lateinit   var gender:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeractivity)

        var  sharedPrefManager = SharedPrefManager(this)
        if (sharedPrefManager.getInstance(this).isLoggedIn())
        {
finish()

            this.startActivity(Intent(this, MainActivity::class.java))
            return
        }
        btn_regist.setOnClickListener {
//            if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(email)){
//
//                Toast.makeText(this,"All Fields Must be filled First", Toast.LENGTH_SHORT).show()
//
//            }else{
//
//
//                registerUser()
//            }
            registerUser()




        }
      //  registerUser()



    }


    private fun registerUser(){
        username = edt_register_userame.text.toString()
        password = edt_register_pass.text.toString()
        email = edt_register_email.text.toString()
        /*val r:RadioButton=radio.checkedRadioButtonId as RadioButton
        gender=r.text.toString()*/

        //radio.checkedRadioButtonId./

        radio1.check(R.id.male)

        val v:RadioButton=findViewById(radio1.checkedRadioButtonId)
       gender= v.text.toString()
Log.d("Gender",gender)







        var url = URLs()
        val params = HashMap<String,String>()
        params["username"] = username
        params["password"] = password
        params["email"] = email
        params["gender"] = gender

        val jsonObject = JSONObject(params)
// Volley post request with parameters
        val request = JsonObjectRequest(Request.Method.POST,url.URL_REGISTER,jsonObject,
            Response.Listener {
                // Process the json
                this.startActivity(Intent(this, MainActivity::class.java))

            }, Response.ErrorListener{
                // Error in request
                Log.d("Log in Error","Error While logging in")
               // textView.text = "Volley error: $it"
            })
        /*var volleySingleton= VolleySingleton(this)
        volleySingleton.getInstance(this).addToRequestQueue(request)*/


        Volley.newRequestQueue(this).add(request)

    }


}
