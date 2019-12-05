package id.co.iconpln.mylistapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loadArrayAdapter()
        loadListBaseAdapter(this)
        setListItemClickListener(lvListHero)
    }


    private fun setListItemClickListener(listView: ListView) {
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(adapterView: AdapterView<*>?, view: View?, index: Int, l: Long) {
                Toast.makeText(this@MainActivity, "You choose: ${list[index].name}", Toast.LENGTH_LONG).show()
                showDetailHero(list[index])
            }
        }
    }

    private  fun showDetailHero(hero: Hero) {
        val detailHeroIntent = Intent(this, DetailHeroActivity::class.java)

        // sending data using intent
        // detailHeroIntent.putExtra(DetailHeroActivity.EXTRA_NAME, hero.name)
        // detailHeroIntent.putExtra(DetailHeroActivity.EXTRA_DESC, hero.desc)
        // detailHeroIntent.putExtra(DetailHeroActivity.EXTRA_IMAGE_URL, hero.photo)
        // startActivity(detailHeroIntent)

        // sending data using bundle
        // val bundle = Bundle()
        // bundle.putString(DetailHeroActivity.EXTRA_NAME, hero.name)
        // bundle.putString(DetailHeroActivity.EXTRA_DESC, hero.desc)
        // bundle.putString(DetailHeroActivity.EXTRA_IMAGE_URL, hero.photo)
        // detailHeroIntent.putExtras(bundle)
        // startActivity(detailHeroIntent)

        // using object
        detailHeroIntent.putExtra(DetailHeroActivity.EXTRA_HERO, hero)
        startActivity(detailHeroIntent)
    }

    fun loadArrayAdapter() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getDataHero())
        lvListHero.adapter = adapter
    }

    fun loadListBaseAdapter(context: Context) {
        list.addAll(HeroesData.listDataHero)

        val baseAdapter = ListViewHeroAdapter(context, list)
        lvListHero.adapter = baseAdapter
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
