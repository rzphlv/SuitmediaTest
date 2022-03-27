package com.rzphlv.suitmediatest

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et_name : EditText = findViewById(R.id.name)
        val et_palindrome : EditText = findViewById(R.id.palindrome)
        val bt_next : Button = findViewById(R.id.bt_next)
        val bt_check : Button = findViewById(R.id.bt_check)

        bt_next.setOnClickListener(View.OnClickListener {
            val name: String = et_name.text.toString()
            val intent = Intent(applicationContext, SecondScreen::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        })

        bt_check.setOnClickListener(View.OnClickListener {
            var pal: String = et_palindrome.text.toString()
            pal = pal.replace("\\s".toRegex(), "")
            if (isPalindrome(pal)){
                AlertDialog.Builder(this)
                    .setMessage("isPalindrome").show()
            } else {
                AlertDialog.Builder(this)
                    .setMessage("not Palindrome").show()
            }
        })
    }

    private fun isPalindrome(text: String): Boolean {
        val reverseString = text.reversed()
        return text.equals(reverseString, ignoreCase = true)
    }
}