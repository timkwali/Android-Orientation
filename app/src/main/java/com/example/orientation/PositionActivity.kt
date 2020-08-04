package com.example.orientation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_position.*

class PositionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position)

        val fragment1 = Position1Fragment()
        val fragment2 = Position2Fragment()
        val fragment3 = Position3Fragment()
        val addButton = findViewById<Button>(R.id.btnAddFragment)
        val removeButton = findViewById<Button>(R.id.btnRemoveFragment)

        //ADD FRAGMENT
        addButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                var backCount = supportFragmentManager.backStackEntryCount
                val bundle = Bundle()
                var nextFragment = Fragment()
                bundle.putInt("count", backCount)

                when (backCount) {
                    0 -> { nextFragment = fragment1 }
                    1 -> { nextFragment = fragment2 }
                    2 -> { nextFragment = fragment3 }
                    else ->  ""//Toast.makeText(this, "NO more Fragments to add", Toast.LENGTH_LONG)

                }

                if(backCount < 3) {
                    supportFragmentManager.beginTransaction().apply {
                        nextFragment.setArguments(bundle)
                        addToBackStack(null)
                        replace(R.id.flPositions, nextFragment)
                        commit()
                    }
                }
            }
        }

        //REMOVE LAST FRAGMENT
        removeButton.setOnClickListener {
            val fragmentManager = supportFragmentManager
            if(fragmentManager.backStackEntryCount > 0) {
                fragmentManager.popBackStack()
            }
        }

//        fun onBackPressed() {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }

    }
}