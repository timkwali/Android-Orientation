package com.example.orientation

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import kotlinx.android.synthetic.main.activity_main.*

var orientationCount = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON CREATE"
        }
        var hand = Handler()
        hand.postDelayed(run , 1000)

        //COUNT ORIENTATION CHANGE
        if (savedInstanceState != null){
            orientationCount = savedInstanceState.getInt("orientationC")
        }
        tvOrientationCount.text = "$orientationCount"
        Log.d("Tag", "The new count is $orientationCount")

        //GO TO NEXT ACTIVITY
        val button = findViewById<Button>(R.id.btnNextActivity)
        button.setOnClickListener{
            val intent = Intent(this, PositionActivity::class.java)
            startActivity(intent)
        }

        //GET CURRENT ORIENTATION
        val tvOrientation = findViewById<TextView>(R.id.tvOrientation)
        val orientation: Int =  this.resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            tvOrientation.text = "PORTRAIT MODE"
            orientationCount++;
            var orien: TextView = findViewById(R.id.tvOrientationCount)

        } else {
            tvOrientation.text = "LANDSCAPE MODE"
            orientationCount++;
            var orien: TextView = findViewById(R.id.tvOrientationCount)

        }

        //GET CURRENT STATE
        var state = findViewById<TextView>(R.id.tvState)
        state.text = lifecycle.currentState.toString()
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt("orientationC", orientationCount)
        Log.d("TAG", "$orientationCount")
    }

    override fun onStart() {
        super.onStart()
        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON START"
        }
        var hand = Handler()
        hand.postDelayed(run , 1500)
    }

    override fun onResume() {
        super.onResume()
        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON RESUME"
        }
        var hand = Handler()
        hand.postDelayed(run , 2000)
    }


    override fun onPause() {
        super.onPause()
        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON PAUSE"
        }
        var hand = Handler()
        hand.postDelayed(run , 2500)
    }


    override fun onStop() {
        super.onStop()
        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON STOP"
        }
        var hand = Handler()
        hand.postDelayed(run , 3000)
    }


    override fun onRestart() {
        super.onRestart()
        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON RESTART"
        }
        var hand = Handler()
        hand.postDelayed(run , 3500)
    }


    override fun onDestroy() {
        super.onDestroy()
        //SHOW CURRENT STATE
        var run  = Runnable {
            tvState.text = "ON RESTART"
        }
        var hand = Handler()
        hand.postDelayed(run , 4000)
    }
}


