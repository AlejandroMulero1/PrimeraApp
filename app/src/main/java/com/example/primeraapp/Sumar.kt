package com.example.primeraapp

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Suma : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        //Creo una variable vista para usarla de referencia despues
        val view: View = inflater.inflate(R.layout.fragment_sumar, container, false)

        /* Implemento el codigo en el onCreateView para tener acceso al metodo "findViewById" y
        defino las variables */
        val btnSumar = view.findViewById(R.id.btnSumar) as Button
        var etxtNum = view.findViewById(R.id.etxtNum) as EditText
        var etxtNum2 = view.findViewById(R.id.etxtNum2) as EditText
        var txtResultado = view.findViewById(R.id.txtResultado) as TextView
        val dialogBuilder = AlertDialog.Builder(requireActivity())
        dialogBuilder.setMessage("Numeros incorrectos, intente de nuevo")

        /* Implemento el código relacionado con la pulsación del botón, añadiendo un try catch
        para manejar la posible excepcion de que el usuario no introduzca ningun numero */
        btnSumar.setOnClickListener{
            try {
                val num1 = etxtNum.text.toString().toInt() //Obtengo el valor numerico del texto
                val num2 = etxtNum2.text.toString().toInt()
                val result = num1 + num2
                txtResultado.text = result.toString() //Devuelvo el numero a cadena para poder mostrarlo
            }
            /*Captura la excepcion producida en la suma de caracteres nulos y llama al dialogBuilder
            definido arriba */
            catch (e:java.lang.Exception){
                val errorSuma = dialogBuilder.create()
                errorSuma.setTitle("Error en la suma")
                errorSuma.show()
            }
        }
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            Suma().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}