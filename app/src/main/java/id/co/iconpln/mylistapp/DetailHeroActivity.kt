package id.co.iconpln.mylistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMAGE_URL = "extra_image_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)
    }
}
