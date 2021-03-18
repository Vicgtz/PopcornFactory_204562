package gutierrez.leal.popcornfactor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.iterator
import java.util.ArrayList

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val bundle = intent.extras

        val title: TextView= findViewById(R.id.titleSeats)
        var posMovie = -1
        var numberSeat: Int = -1
        var listSeats: ArrayList<Cliente>? = null
        var movies: ArrayList<Pelicula>? = null
        var listrows: ArrayList<RadioGroup>? = null


        if (bundle!=null){
           title.setText(bundle.getString("name"))
           posMovie= bundle.getInt("id")
            listSeats = bundle.get("seatslist") as ArrayList<Cliente>
            movies= bundle.get("movies") as ArrayList<Pelicula>
            listrows = ArrayList<RadioGroup>()

        }

        val confirm: Button = findViewById(R.id.confirm)

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        listrows?.add(row1);
        listrows?.add(row2);
        listrows?.add(row3);
        listrows?.add(row4);

        if (listSeats != null && listrows != null) {
            clearIdRadios(listrows)
            checkSeats(listSeats, listrows)
        }

        confirm.setOnClickListener{
            if (numberSeat != -1) {
                val intent: Intent = Intent(this, comprarBoleto::class.java)

                intent.putExtra("numberseat", numberSeat)
                intent.putExtra("id", posMovie)
                intent.putParcelableArrayListExtra("seatslist", listSeats)
                intent.putParcelableArrayListExtra("movies", movies)
                this.startActivity(intent)
            }
        }

        row1.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                val rb: RadioButton = group.getChildAt(checkedId-1) as RadioButton
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                numberSeat = rb.text.toString().toInt()
                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                val rb: RadioButton = group.getChildAt(checkedId-1) as RadioButton
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                numberSeat = rb.text.toString().toInt()
                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                val rb: RadioButton = group.getChildAt(checkedId-1) as RadioButton
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                numberSeat = rb.text.toString().toInt()
                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                val rb: RadioButton = group.getChildAt(checkedId-1) as RadioButton
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                numberSeat = rb.text.toString().toInt()
                row4.check(checkedId)
            }
        }

    }

    fun checkSeats(Seats: ArrayList<Cliente>, rows: ArrayList<RadioGroup>) {
        var index: Int = -1
        var subIndex: Int = -1
        for (seat in Seats) {
            index = seat.seat
            subIndex = index % 5
            if (subIndex == 0) {
                subIndex = 5
            }
            when (index) {
                in 1..5 -> {
                    rows.get(0).getChildAt(subIndex-1).isEnabled = false
                }
                in 6..10 -> {
                    rows.get(1).getChildAt(subIndex-1).isEnabled = false
                }
                in 11..15 -> {
                    rows.get(2).getChildAt(subIndex-1).isEnabled = false
                }
                in 16..20 -> {
                    rows.get(3).getChildAt(subIndex-1).isEnabled = false
                }
            }

        }
    }

    fun clearIdRadios(rowsGroups: ArrayList<RadioGroup>) {
        var idRow: Int = -1
        for (rowgroup in rowsGroups) {
            for (row in rowgroup) {
                idRow = row.id % 5
                if (idRow == 0) {
                    idRow = 5
                }
                row.id = idRow
            }
        }
    }





}