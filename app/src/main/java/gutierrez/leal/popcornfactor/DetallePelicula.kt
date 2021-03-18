package gutierrez.leal.popcornfactor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*
import java.util.ArrayList

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var ns = 0;
        var id = 0;
        var title = "";
        var listSeats: ArrayList<Cliente>? = null;
        var movies: ArrayList<Pelicula>? = null;

        if(bundle != null){
            ns = bundle.getInt("numberSeats")
            title= bundle.getString("titulo")!!
            listSeats = bundle?.get("seatslist") as ArrayList<Cliente>
            movies = bundle?.getParcelableArrayList("movies")

            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_pelicula_nombre.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsleft.setText("$ns seats available")
            id = bundle.getInt("pos")
        }
        if(ns==0){
            buyTickets.isEnabled=false
        } else{
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("name", title)

                intent.putParcelableArrayListExtra("seatslist",listSeats)
                intent.putParcelableArrayListExtra("movies",movies)


                this!!.startActivity(intent)
            }
        }





    }
}