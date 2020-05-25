package com.pvduc9773

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

    companion object {
        const val EXTRA_STRING = "extra-string"
        const val EXTRA_INT = "extra-int"
        const val EXTRA_SERIALIZABLE = "extra-serializable"
    }

    @GetValue(EXTRA_STRING)
    private val valueString: String? = null

    @GetValue(EXTRA_INT)
    private val valueInt: Int? = null

    @GetValue(EXTRA_SERIALIZABLE)
    private val valueSerializable: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { StdBindValue.bindValue(this, it) }
        Toast.makeText(context, valueSerializable.toString(), Toast.LENGTH_SHORT).show()
    }

}
