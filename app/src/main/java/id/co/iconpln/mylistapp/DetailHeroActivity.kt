package id.co.iconpln.mylistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_hero.*

class DetailHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMAGE_URL = "extra_image_url"

        const val EXTRA_HERO = "extra_hero"
    }

    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)

        initIntentExtras()
        displayHeroDetail()
        setupActionbar()
    }

    private fun setupActionbar() {
        supportActionBar?.title = "Detail Hero"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // object
    private fun initIntentExtras() {
        hero = intent.getParcelableExtra(EXTRA_HERO)
    }

    private fun displayHeroDetail() {
        // using intent
        // tvHeroDetailName.text = intent.getStringExtra(EXTRA_NAME)
        // tvHeroDetailDesc.text = intent.getStringExtra(EXTRA_DESC)
        // .load(intent.getStringExtra(EXTRA_IMAGE_URL))

        // using bundle
        // val bundle = intent.extras
        // tvHeroDetailName.text = bundle?.getString(EXTRA_NAME)
        // tvHeroDetailDesc.text = bundle?.getString(EXTRA_DESC)
        // .load(bundle?.getString(EXTRA_IMAGE_URL))

        // using object
        tvHeroDetailName.text = hero.name
        tvHeroDetailDesc.text = hero.desc

        Glide.with(this)
            .load(hero.photo)
            .apply(
                RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(ivHeroDetailImage)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                false
            }
        }
    }
}
