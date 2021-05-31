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
    lateinit var editLGAC: EditText
    lateinit var btnGuardarProyecto : Button
    lateinit var btnSalir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_proyectos)

        editNombre = findViewById(R.id.editNombre)
        editdescripcion = findViewById(R.id.editdescripcion)
        editEncargado = findViewById(R.id.editEncargado)
        editLGAC = findViewById(R.id.editLGAC)

        btnGuardarProyecto = findViewById(R.id.btnGuardarProyecto)
        btnSalir = findViewById(R.id.btnSalir)

        btnSalir.setOnClickListener { finish() }

        val stringBD = intent.getStringExtra("bd")

        var jsonBD = JSONObject(stringBD)

        btnGuardarProyecto.setOnClickListener {
            val json = JSONObject()
            json.put("nombre_empresa", editNombre.text.toString())
            json.put("Descripcion", editdescripcion.text.toString())
            json.put("Encargado", editEncargado.text.toString())
            json.put("LGAC", editLGAC.text.toString())


           val proyectos = jsonBD.getJSONArray("proyectos")
                proyectos.put(json)

            jsonBD = JSONObject()
            jsonBD.put("proyectos", proyectos)

            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("proyecto", json.toString())
            intent.putExtra("bd", jsonBD.toString())
            startActivity(intent)
            finish()
        }

    }

}