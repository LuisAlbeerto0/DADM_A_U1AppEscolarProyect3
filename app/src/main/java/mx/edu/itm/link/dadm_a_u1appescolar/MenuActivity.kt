package mx.edu.itm.link.dadm_a_u1appescolar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    lateinit var btnKardex : Button
    lateinit var btnHorario : Button
    lateinit var btnReticula : Button
    lateinit var btnPersonales : Button
    lateinit var btnResidencias : Button

    lateinit var stringBD : String
    lateinit var stringBD2 : String
    lateinit var stringAlumno : String
    lateinit var stringProyecto: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnKardex = findViewById(R.id.btnKardex)
        btnHorario = findViewById(R.id.btnHorario)
        btnReticula = findViewById(R.id.btnReticula)
        btnPersonales = findViewById(R.id.btnPersonales)

        btnResidencias = findViewById(R.id.btnResidencias)

        stringBD = intent.getStringExtra("bd")
        //stringBD2 = intent.getStringExtra("bd")
        if(stringBD == null) {
            stringBD = resources.getString(R.string.jsonAlumnos)
            //stringBD2 = resources.getString(R.string.jsonproyectos)
        }





        stringAlumno = intent.getStringExtra("alumno")
        //stringProyecto= intent.getStringExtra("proyecto")

        println("BD:")
        println(stringBD)

        println("Proyecto: ")
      //  println(stringProyecto)

        btnKardex.setOnClickListener {
            invocarActivity(KardexActivity::class.java)
        }

        btnReticula.setOnClickListener {
            invocarActivity(AcademicAdvanceActivity::class.java)
        }

        btnHorario.setOnClickListener {
            invocarActivity(ScheduleActivity::class.java)
        }
        btnResidencias.setOnClickListener {
            invocarActivity(Residencias_registro::class.java)
        }

    }

    private fun invocarActivity(clase : Class<*>) {
        val intent = Intent(this,clase)
        intent.putExtra("bd",stringBD)
        //intent.putExtra("bd2",stringBD2)
        intent.putExtra("alumno",stringAlumno)
       //  intent.putExtra("proyectos",stringProyecto)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            data?.getStringExtra("alumno")?.let {
                stringAlumno = it
                println(it)
            }
            data?.getStringExtra("bd")?.let {
                stringBD = it
                println(it)
            }

        }
    }

}