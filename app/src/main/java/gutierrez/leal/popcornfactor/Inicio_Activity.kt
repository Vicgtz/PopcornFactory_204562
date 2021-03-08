package gutierrez.leal.popcornfactor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_)

        var menu: Button = findViewById(R.id.welcome_button) as Button

        menu.setOnClickListener {
            var intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}