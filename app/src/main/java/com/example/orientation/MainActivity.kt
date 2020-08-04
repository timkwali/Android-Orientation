package com.example.orientation

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        } else {
            tvOrientation.text = "LANDSCAPE MODE"
        }

        //GET CURRENT STATE
        var state = findViewById<TextView>(R.id.tvState)
        state.text = lifecycle.currentState.toString()
    }

    //SET COUNTER ON ORIENTATION CHANGE
//    var orientationCount = 0
//    var orien: TextView = findViewById(R.id.tvOrientationCount)

//    fun onConfigurationChange(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig);
//    }

//    override fun onSaveInstanceState(outState: Bundle){
//        super.onSaveInstanceState(outState)
//        outState.putInt("orientationC", orientationCount)
//    }

    override fun onStart() {
        super.onStart()
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        orientationCount = savedInstanceState.getInt("orientationC")
//        orientationCount++
//        orien.text = "$orientationCount"
//    }
}


