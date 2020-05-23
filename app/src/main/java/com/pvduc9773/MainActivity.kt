package com.pvduc9773

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHelloWorld.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.EXTRA_STRING, "value-string")
            intent.putExtra(SecondActivity.EXTRA_INT, 1111)
            intent.putExtra(SecondActivity.EXTRA_SERIALIZABLE, User("001", "pvduc9773"))
            startActivity(intent)
        }
    }
}

class User(var id: String, val name: String) : Serializable {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}
