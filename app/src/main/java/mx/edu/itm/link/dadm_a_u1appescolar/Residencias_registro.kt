package mx.edu.itm.link.dadm_a_u1appescolar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Residencias_registro : AppCompatActivity() {
   // lateinit var btnResP : Button
    lateinit var btnResR : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_residencias_registro2)

        val btnResP: Button = findViewById(R.id.btnResP)
        val btnResR: Button = findViewById(R.id.btnResR)



        btnResP.setOnClickListener {
            invocarActivity2(Proyectos_disponibles::class.java)

        }
        btnResR.setOnClickListener {
                invocarActivity2(Registrar_proyectos::class.java)
            }

    }
    private fun invocarActivity2(clase : Class<*>) {
        val intent = Intent(this,clase)
        startActivityForResult(intent, 1)
    }
}