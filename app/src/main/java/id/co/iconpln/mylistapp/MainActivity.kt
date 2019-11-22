package id.co.iconpln.mylistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getDataHero())
        lvListHero.adapter = adapter
    }

    fun getDataHero(): Array<String> {
        val hero = arrayOf(
            "Cut Nyak Dien",
            "Ki Hajar Dewantara",
            "Moh Yamin",
            "Soekarno",
            "Moh Hatta",
            "R.A Kartini"
        )
        return hero
    }
}
