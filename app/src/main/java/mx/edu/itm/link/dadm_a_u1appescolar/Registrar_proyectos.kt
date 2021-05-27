package mx.edu.itm.link.dadm_a_u1appescolar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class Registrar_proyectos : AppCompatActivity() {

    lateinit var editNombre : EditText
    lateinit var editdescripcion : EditText
    lateinit var editEncargado : EditText
    lateinit var btnGuardarProyecto : Button
    lateinit var btnSalir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_proyectos)

       editNombre = findViewById(R.id.editNombre)
        editdescripcion = findViewById(R.id.editdescripcion)
        editEncargado = findViewById(R.id.editEncargado)

        btnGuardarProyecto = findViewById(R.id.btnGuardarProyecto)
        btnSalir = findViewById(R.id.btnSalir)

        btnSalir.setOnClickListener { finish() }

       // val stringBD = intent.getStringExtra("bd")

       // var jsonBD = JSONObject(stringBD)

        btnGuardarProyecto.setOnClickListener {
            val json = JSONObject()
            json.put("nombre_proyecto", editNombre.text.toString())
            json.put("Descripcion", editdescripcion.text.toString())
            json.put("Encargado", editEncargado.text.toString())


           // val Proyectos = jsonBD.getJSONArray("proyectos")
           //       Proyectos.put(json)

          //  jsonBD = JSONObject()
          //  jsonBD.put("proyectos", Proyectos)

            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("proyectos", json.toString())
          //  intent.putExtra("bd", jsonBD.toString())
            startActivity(intent)
            finish()
        }

    }

}