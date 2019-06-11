package com.akash.webserviceauthentication.Util

import android.app.Activity
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

public class VolleySingleton{

    private lateinit var mInstance : VolleySingleton
    private var mRequesQueue:RequestQueue
        private  var mCtx:Activity


    constructor( mCtx: Activity) {
        this.mRequesQueue = getRequestQueue()
        this.mCtx = mCtx
    }

    public fun getRequestQueue(): RequestQueue {
if (mRequesQueue == null){

    mRequesQueue = Volley.newRequestQueue(mCtx)

}
return mRequesQueue   }

public fun getInstance(contxt :Activity): VolleySingleton {
if (mInstance == null){

    mInstance = VolleySingleton(contxt)


}
return mInstance

}

    fun <T> addToRequestQueue(req: Request<T>) {
        getRequestQueue()!!.add(req)
    }


}