package com.example.primeraapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CambiarColor : Fragment() {
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
        val view: View = inflater.inflate(R.layout.fragment_cambiar_color, container, false)
        val btnAzul= view.findViewById(R.id.btnAzul) as Button
        val btnVerde= view.findViewById(R.id.btnVerde) as Button
        val btnRojo= view.findViewById(R.id.btnRojo) as Button
        val  txtCambiarColor=view.findViewById(R.id.txtCambiarColor) as EditText
        //Creo un evento para cada pulsacion de boton en el que cambie el texto al respectivo boton
        btnAzul.setOnClickListener{
            txtCambiarColor.setTextColor(Color.parseColor("#323ea8")) //Azul
        }
        btnVerde.setOnClickListener{
            txtCambiarColor.setTextColor(Color.parseColor("#cf2d27")) //Verde
        }
        btnRojo.setOnClickListener{
            txtCambiarColor.setTextColor(Color.parseColor("#38cf27")) //Rojo

        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            CambiarColor().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}