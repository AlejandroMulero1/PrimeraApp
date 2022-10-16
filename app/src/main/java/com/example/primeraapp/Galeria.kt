package com.example.primeraapp

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Galeria : Fragment() {

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
        savedInstanceState: Bundle?
    ): View? {
        val view: View =inflater.inflate(R.layout.fragment_galeria, container, false)
        val img1=view.findViewById(R.id.img1) as ImageView
        val img2=view.findViewById(R.id.img2) as ImageView
        val img3=view.findViewById(R.id.img3) as ImageView
        val btnAnterior=view.findViewById(R.id.btnAnterior) as Button
        val btnSiguiente=view.findViewById(R.id.btnSiguiente) as Button
        var indice=0
        btnSiguiente.setOnClickListener {
            indice++
            if (indice==3) indice=0
            if (indice==0){
                img1.visibility=View.VISIBLE
                img2.visibility=View.GONE
                img3.visibility=View.GONE
            }

            if (indice==1){
                img1.visibility=View.GONE
                img2.visibility=View.VISIBLE
                img3.visibility=View.GONE
            }
            if (indice==2){
                img1.visibility=View.GONE
                img2.visibility=View.GONE
                img3.visibility=View.VISIBLE
            }


        }
        btnAnterior.setOnClickListener {
            indice--
            if (indice==-1) indice=3
            if (indice==0){
                img1.visibility=View.VISIBLE
                img2.visibility=View.GONE
                img3.visibility=View.GONE
            }

            if (indice==1){
                img1.visibility=View.GONE
                img2.visibility=View.VISIBLE
                img3.visibility=View.GONE
            }
            if (indice==2){
                img1.visibility=View.GONE
                img2.visibility=View.GONE
                img3.visibility=View.VISIBLE
            }


        }
        return view
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            Galeria().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}