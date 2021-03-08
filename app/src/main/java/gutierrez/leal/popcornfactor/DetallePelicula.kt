package gutierrez.leal.popcornfactor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras

        if(bundle != null){
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_pelicula_nombre.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
        }



    }
}