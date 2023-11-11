package com.mpip.labs.lab_intents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    /* Request Codes:
        1 - Explicit Activity
        2 - Image Select
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
    }

    fun onExplicitActivityPressed(view: View){
        val explicitIntent = Intent(this, ExplicitActivity::class.java)
        startActivityForResult(explicitIntent, 1)
    }

    fun onImplicitActivityPressed(view: View){
        var implicitIntent = Intent(this, ImplicitActivity::class.java)
        startActivity(implicitIntent)
    }

    fun onSelectImagePressed(view: View){
        val imageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        imageIntent.setType("image/*")
        startActivityForResult(imageIntent, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK) {
                val textFromInput = data?.getStringExtra("input")
                if (textFromInput != null) {
                    textView.text = textFromInput
                }
            }
        } else if (requestCode == 2){
            if(resultCode == Activity.RESULT_OK && data != null && data.data != null){
                val imageUri: Uri = data.data!!
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(imageUri, "image/*")
                startActivity(intent)
            }
        }
    }

}