package com.akash.webserviceauthentication.Util

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.akash.webserviceauthentication.Activity.Loginactivity
import com.akash.webserviceauthentication.Models.User
import java.lang.reflect.Modifier
import android.support.v4.content.ContextCompat.startActivity



public class SharedPrefManager{

    private val SHARED_PREF_NAME:String? = "volleyregisterlogin"
    private val KEY_USERNAME:String? = "keyusername"
    private val KEY_EMAIL:String? = "keyemail"
    private val KEY_GENDER:String? = "keygender"
    private val KEY_ID :String?= "keyid"
    private var mInstance: SharedPrefManager? = null

    private var ctx: Context? = null

   public constructor(context: Context){

       ctx=context
   }

    public fun getInstance(contxt :Context): SharedPrefManager {
        if (mInstance == null){

            mInstance = SharedPrefManager(contxt)


        }
        return mInstance as SharedPrefManager

    }



    public fun userLogin (user: User){

        var sharedPreferences:SharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)


        var editor:SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(KEY_ID, user.getId()!!)
editor.putString(KEY_USERNAME,user.getName())
        editor.putString(KEY_EMAIL,user.getEmail())
        editor.putString(KEY_GENDER,user.getGender())

        editor.apply()

    }

public fun isLoggedIn():Boolean{

    var sharedPreferences:SharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)
return sharedPreferences.getString(KEY_USERNAME,null)!=null

}


    public fun getUser():User{

var sharedPreferences:SharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)

        return User(sharedPreferences.getInt(KEY_ID,-1),sharedPreferences.getInt(KEY_USERNAME,null!!).toString() ,sharedPreferences.getInt(KEY_EMAIL,null!!).toString(),sharedPreferences.getInt(KEY_GENDER,null!!).toString())

    }
public fun logout(){


   var sharedPreferences:SharedPreferences = ctx!!.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)
    var editor:SharedPreferences.Editor = sharedPreferences.edit()

    editor.clear()
    editor.apply()

//var intent:Intent? = Intent(ctx,Loginactivity::class.java)


    ctx!!.startActivity(Intent(ctx, Loginactivity::class.java))


}



}


