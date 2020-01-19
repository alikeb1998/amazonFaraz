package com.maktab.amazonfaraz.view.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.maktab.amazonfaraz.R

class Splash : AppCompatActivity() {
    private var wifiImageView: ImageView? = null
    private var textIntenetCheck: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        wifiImageView=findViewById(R.id.imageViewWifi)
        textIntenetCheck=findViewById(R.id.textViewWifi)
        if (isNetworkConnected()) run {

            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }else
        {
            wifiImageView!!.visibility = View.VISIBLE
            textIntenetCheck!!.visibility = View.VISIBLE
            finishActivity(1)
        }
    }
    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}
