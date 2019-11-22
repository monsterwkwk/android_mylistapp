package id.co.iconpln.mylistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewHeroAdapter(val context: Context, val listHero: ArrayList<Hero>):BaseAdapter() {
    override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewLayout = LayoutInflater.from(context)
            .inflate(R.layout.item_list_hero, viewGroup, false)

        val viewHolder = ViewHolder(viewLayout)
        val hero = getItem(index) as Hero
        viewHolder.bind(context, hero)

        return viewLayout
    }

    override fun getItem(index: Int): Any {
        return listHero[index]
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getCount(): Int {
        return listHero.size
    }

    private inner class ViewHolder(view: View) {
        private val tvHeroName: TextView = view.findViewById(R.id.tvTitle)
        private val tvHeroDesciption: TextView = view.findViewById(R.id.tvDescription)
        private val ivHeroPhoto: ImageView = view.findViewById(R.id.ivHeroImage)

        fun bind(context: Context, hero: Hero) {
            tvHeroName.text = hero.name
            tvHeroDesciption.text = hero.desc
        }
    }

}