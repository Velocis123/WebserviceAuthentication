package com.akash.webserviceauthentication.Util

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

public class VolleySingleton{

    private var mInstance : VolleySingleton?=null
    private var mRequesQueue: RequestQueue?=null
    private var mCtx:Context?=null


    constructor( mCtx: Context?) {
        this.mRequesQueue = getRequestQueue()
        this.mCtx = mCtx
    }

    public fun getRequestQueue(): RequestQueue? {
if (mRequesQueue == null){

    mRequesQueue = Volley.newRequestQueue(mCtx!!.applicationContext)

}
return mRequesQueue   }

public fun getInstance(contxt :Context): VolleySingleton {
if (mInstance == null){

    mInstance = VolleySingleton(contxt)


}
return mInstance as VolleySingleton

}

    fun <T> addToRequestQueue(req: Request<T>) {
        getRequestQueue()!!.add(req)
    }


}