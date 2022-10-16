package com.example.primeraapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CambiarTexto : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_cambiar_texto, container, false)
        val txtCambiarText=view.findViewById(R.id.id1) as EditText
        val cbNegrita = view.findViewById(R.id.cbNegrita) as CheckBox
        val cbFuenteMinuscula = view.findViewById(R.id.cbFuenteMinuscula) as CheckBox
        val cbFuenteGigante = view.findViewById(R.id.cbFuenteGigante) as CheckBox
        val cbRojo = view.findViewById(R.id.cbRojo) as CheckBox
        cbRojo.setOnClickListener{
            if (cbRojo.isChecked)
            txtCambiarText.setTextColor(Color.parseColor("#C43F22"))
            else{
                txtCambiarText.setTextColor(Color.parseColor("#000000"))
            }
        }
        cbFuenteGigante.setOnClickListener {
            if (cbFuenteGigante.isChecked)
            txtCambiarText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
            else{
                txtCambiarText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
            }
        }
        cbFuenteMinuscula.setOnClickListener {
            if (cbFuenteMinuscula.isChecked)
            txtCambiarText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 5f)
            else {
                txtCambiarText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
            }
        }
        cbNegrita.setOnClickListener {
            if (cbNegrita.isChecked)
            txtCambiarText.setTypeface(null, Typeface.BOLD)
            else{
                txtCambiarText.setTypeface(null, Typeface.NORMAL)
            }
        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            CambiarTexto().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}