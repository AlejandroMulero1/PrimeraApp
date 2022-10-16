package com.example.primeraapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.view.isInvisible
import androidx.core.view.isVisible


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class imagen : Fragment() {

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
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_imagen, container, false)
        val btnSol = view.findViewById(R.id.imgSol) as ImageButton
        val btnLuna=view.findViewById(R.id.imgLuna) as ImageButton
        /*Al pulsar el boton sol la visibilidad del boton se hace nula
        y el boton luna se hace visible*/
        btnSol.setOnClickListener{
            btnSol.visibility= View.GONE
            btnLuna.visibility = View.VISIBLE
        }
        /*Al pulsar el boton luna la visibilidad del boton se hace nula
        y el boton sol se hace visible*/
        btnLuna.setOnClickListener{
            btnSol.visibility= View.VISIBLE
            btnLuna.visibility = View.GONE
        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            imagen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}