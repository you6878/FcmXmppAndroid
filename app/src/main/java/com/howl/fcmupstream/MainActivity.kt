package com.howl.fcmupstream

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val FCM_PROJECT_SENDER_ID = "757925985579"
    val FCM_SERVER_CONNECTION = "@gcm.googleapis.com"
    val RANDOM = Random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseInstanceId.getInstance().token
        button.setOnClickListener {
            val message = editText.text.toString()
            FirebaseMessaging.getInstance().send(RemoteMessage.Builder(FCM_PROJECT_SENDER_ID + FCM_SERVER_CONNECTION)
                    .setMessageId(Integer.toString(RANDOM.nextInt()))
                    .addData("message", message)
                    .build())
        }
    }
}
