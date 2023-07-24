package com.example.imagenfsw

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fir : FirebaseAuth = FirebaseAuth.getInstance()


        msg()


        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result

                Log.e("TAG", "onCreate:    -------->     token  "+token )

                // Log and toast
//                val msg = getString(R.string.msg_token_fmt, token)
//                Log.d("TAG", msg)
//                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            })

     }

    private fun msg(){
        FirebaseAuth.getInstance().signInWithCustomToken("123")
        FirebaseMessaging.getInstance().subscribeToTopic("All")
    }
}