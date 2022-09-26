package com.example.political_binner

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

lateinit var toogle:ActionBarDrawerToggle
class MainActivity : AppCompatActivity() {
    val listimg=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        for (i in 0 until listimg.size){
            showimg(listimg[i])

        }


        val drawerlayout: DrawerLayout = findViewById(R.id.drawable_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        toogle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            drawable_layout.closeDrawer(GravityCompat.START)

            when (it.itemId) {
                R.id.more -> {

                    Toast.makeText(
                        applicationContext, "More apps", Toast.LENGTH_SHORT
                    ).show()


                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/dev?id=620123")
                        )
                    )


                }


                R.id.rate -> {
                    Toast.makeText(
                        applicationContext, "More apps", Toast.LENGTH_SHORT
                    ).show()


                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
                        )
                    )


                }
                R.id.share->{
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                    var shareMessage = "\nLet me recommend you this application\n\n"
                    shareMessage =
                        """
                        ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                        
                        
                        """.trimIndent()
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                    startActivity(Intent.createChooser(shareIntent, "choose one"))
                }


            }


            true

        }





    }


    fun showimg(img:Int){
        val imgview=ImageView(this)
        imgview.setBackgroundResource(img)
        flipper.addView(imgview)
        flipper.flipInterval=3000
        flipper.isAutoStart=true
        flipper.setInAnimation(this, android.R.anim.slide_in_left)
        flipper.setOutAnimation(this, android.R.anim.slide_out_right)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){

            return true

        }
        return super.onOptionsItemSelected(item)
    }
}