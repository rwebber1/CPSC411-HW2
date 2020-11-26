package com.example.homework2

import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity

class ClaimService (val ctx : MainActivity){

    fun add(cObj : Claim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://172.16.0.148:8080/ClaimService/add"
        // 1. Convert the claim object into JSON string
        val cJsonString= Gson().toJson(cObj)
        // 2. Send the post request
        val entity = StringEntity(cJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                val title = ctx.findViewById<EditText>(R.id.claim_title).text.toString()
                Log.d("Claim Service", "The add Service response : ${respStr}")
                ctx.findViewById<TextView>(R.id.message).text = "SUCCESS - claim (${title}) was successfully added!"
                ctx.findViewById<EditText>(R.id.claim_title).text.clear()
                ctx.findViewById<EditText>(R.id.date).text.clear()
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            ctx.findViewById<TextView>(R.id.message).text = "ERROR - claim was not added into database"
            ctx.findViewById<EditText>(R.id.claim_title).text.clear()
            ctx.findViewById<EditText>(R.id.date).text.clear()
        }
    }
}