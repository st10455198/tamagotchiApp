package com.example.tamagotchi

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val eatBtn=findViewById<Button>(R.id.eatBtn)
        val bathBtn=findViewById<Button>(R.id.bathBtn)
        val playBtn=findViewById<Button>(R.id.playBtn)
        val status=findViewById<ImageView>(R.id.actionImg)
        val eatProgressBar=findViewById<ProgressBar>(R.id.eatProgressBar)
        val bathProgressBar=findViewById<ProgressBar>(R.id.bathProgressBar)
        val playProgressBar=findViewById<ProgressBar>(R.id.playProgressBar)
        var eatIncrease=0
        var bathIncrease=0
        var playIncrease=0
        eatProgressBar.max=100
        bathProgressBar.max=100
        playProgressBar.max=100


        fun Again(){
            if (playIncrease>=40 && bathIncrease>=30 && eatIncrease>=50){

                val intent=Intent(this,MainActivity3::class.java)
                startActivity(intent)
            }

        }
        //show default image after desired milliseconds
        fun timer (){
            Handler().postDelayed(
                {
                    status.setImageResource(R.drawable.haappy)
                }
                ,1700
            )
        }

//        change image and increase the gauge for eating bar
        eatBtn.setOnClickListener {
            eatIncrease+=10
            status.setImageResource(R.drawable.eating)
            timer()
            ObjectAnimator.ofInt(eatProgressBar,"progress",eatIncrease).start()
            Again()

        }
//        change the image and increase the gauge for bathing bar
        bathBtn.setOnClickListener {
            bathIncrease+=5
            status.setImageResource(R.drawable.bathingpng)
            timer()
            ObjectAnimator.ofInt(bathProgressBar,"progress",bathIncrease).start()
            Again()
        }
//      change the image and increase the gauge for playing bar
        playBtn.setOnClickListener {
            playIncrease+=8
            status.setImageResource(R.drawable.playingpng)
            timer()
            ObjectAnimator.ofInt(playProgressBar,"progress",playIncrease).start()
            Again()
        }



    }
}