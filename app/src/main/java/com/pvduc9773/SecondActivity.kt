package com.pvduc9773

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STRING = "extra-string"
        const val EXTRA_INT = "extra-int"
        const val EXTRA_SERIALIZABLE = "extra-serializable"
    }

    @GetValue(EXTRA_STRING, TYPE.STRING)
    private val valueString: String? = null

    @GetValue(EXTRA_INT, TYPE.INT)
    private val valueInt: Int? = null

    @GetValue(EXTRA_SERIALIZABLE, TYPE.SERIALIZABLE)
    private val valueSerializable: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        intent.extras?.let { StdBindValue.bindValue(this, it) }
        Toast.makeText(this, valueString, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, valueInt.toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, valueSerializable.toString(), Toast.LENGTH_SHORT).show()

        flContent.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(BlankFragment.EXTRA_STRING, "value-string")
            bundle.putInt(BlankFragment.EXTRA_INT, 1111)
            bundle.putSerializable(BlankFragment.EXTRA_SERIALIZABLE, User("002", "pvduc9773"))

            val blankFragment = BlankFragment()
            blankFragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.flContent, blankFragment)
            transaction.commit()
        }
    }
}
