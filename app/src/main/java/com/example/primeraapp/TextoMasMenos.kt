package com.example.primeraapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TextoMasMenos : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view :View=inflater.inflate(R.layout.fragment_texto_mas_menos, container, false)
        val txtMasMenos=view.findViewById(R.id.txtTextoMasMenos) as EditText
        val btnAumentar=view.findViewById(R.id.btnAumentar) as Button
        val btnDisminuir=view.findViewById(R.id.btnDisminuir) as Button
        var sizeNormal=14f
        btnAumentar.setOnClickListener {
            sizeNormal+=4f
            txtMasMenos.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeNormal)

        }
        btnDisminuir.setOnClickListener {
            sizeNormal-=4f
            txtMasMenos.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeNormal)
        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            TextoMasMenos().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}