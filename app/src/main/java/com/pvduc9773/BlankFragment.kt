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

    @StdExtra(EXTRA_STRING)
    private val valueString: String? = null

    @StdExtra(EXTRA_INT)
    private val valueInt: Int? = null

    @StdExtra(EXTRA_SERIALIZABLE)
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
        arguments?.let { StdBindValue.bind(this, it) }
        Toast.makeText(context, valueSerializable.toString(), Toast.LENGTH_SHORT).show()
    }

}
