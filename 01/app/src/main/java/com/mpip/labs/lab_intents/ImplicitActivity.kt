package com.mpip.labs.lab_intents

import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ImplicitActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)
        textView = findViewById(R.id.implicitTextView)

        val activityList = getActivities()

        val stringBuilder = StringBuilder()
        stringBuilder.append("Листа на сите 'category.LAUNCHER' и 'action.MAIN':\n\n")
        for (listItem in activityList){
            stringBuilder.append(listItem.activityInfo.name).append("\n")
        }

        textView.text = stringBuilder.toString()

    }

    private fun getActivities(): List<ResolveInfo>{
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        return packageManager.queryIntentActivities(intent, 0)
    }

}