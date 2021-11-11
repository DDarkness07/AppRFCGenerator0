package mx.itchetumal.apprfcgenerator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalcular:Button
    private lateinit var btnlimpiar: Button
    private lateinit var edtNombre: EditText
    private lateinit var apPaterno: EditText
    private lateinit var apMaterno: EditText
    private lateinit var año: EditText
    private lateinit var mes: EditText
    private lateinit var dia: EditText
    private lateinit var rf: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular= findViewById(R.id.calcular)
        btnlimpiar = findViewById(R.id.limpiar)
        edtNombre = findViewById(R.id.nombre)
        apPaterno = findViewById(R.id.apPaterno)
        apMaterno = findViewById(R.id.apMaterno)
        año = findViewById(R.id.año)
        mes = findViewById(R.id.mes)
        dia = findViewById(R.id.dia)
        rf = findViewById(R.id.rfc)


        btnCalcular.setOnClickListener {
            calcular(edtNombre.text.toString(),apPaterno.text.toString(), apMaterno.text.toString(), año.text.toString(), mes.text.toString(),dia.text.toString() )
        }
        btnlimpiar.setOnClickListener {
            edtNombre.setText("")
            apPaterno.setText("")
            apMaterno.setText("")
            año.setText("")
            mes.setText("")
            dia.setText("")
            rf.text = "Sin RFC"
        }
    }

    @SuppressLint("SetTextI18n")
    fun calcular(n: String, apP: String, apM: String, y: String, m: String, d: String){
        val nombre =  n
        val apPaterno = apP
        val apMaterno = apM

        val año = y
        val mes = m
        val dia = d
        if(nombre ==""|| apP == "" || apM =="" || y=="" || m =="" || d == ""){
            Toast.makeText(applicationContext, "Agrege almenos un dato", Toast.LENGTH_SHORT).show()
        }else{
            rf.text = ""
            rf.text = "EL RFC es: "+ obtenerPrimeros4(nombre, apPaterno, apMaterno)+obtenerAño(año)+obtenerMes(mes)+dia+"XXX"
            Log.e("RFC","EL RFC es: "+ obtenerPrimeros4(nombre, apPaterno, apMaterno)+obtenerAño(año)+obtenerMes(mes)+dia +"XXX" )
        }

    }

    fun obtenerPrimeros4(n: String, ap1: String, ap2: String): String{
        val dosApePaterno = ap1.substring(0,2).uppercase()
        val unoApeMaterno = ap2.substring(0,1).uppercase()
        val dosNombre = n.substring(0,1).uppercase()

        return dosApePaterno+unoApeMaterno+dosNombre
    }

    fun obtenerAño(año: String): String{
        return año.substring(2,4)
    }

    fun obtenerMes(mes: String): String{
        return when(mes.uppercase()){
            "ENERO"->{
                "01"
            }
            "FEBRERO"->{
                "02"
            }
            "MARZO"->{
                "03"
            }
            "ABRIL"->{
                "04"
            }
            "MAYO"->{
                "05"
            }
            "JUNIO"->{
                "06"
            }
            "JULIO"->{
                "07"
            }
            "AGOSTO"->{
                "08"
            }
            "SEPTIEMBRE"->{
                "09"
            }
            "OBTUBRE"->{
                "10"
            }
            "NOVIEMBRE"->{
                "11"
            }
            "DICIEMBRE"->{
                "12"
            }
            else -> mes
        }
    }


}