package id.co.iconpln.mylistapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListViewHeroAdapter(val context: Context, val listHero: ArrayList<Hero>):BaseAdapter() {
    override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

}