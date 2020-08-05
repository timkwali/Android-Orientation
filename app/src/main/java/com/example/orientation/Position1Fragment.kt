package com.example.orientation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_position1.*


class Position1Fragment : Fragment(R.layout.fragment_position1) {
     override fun onStart() {
        super.onStart()
        var count = this.arguments?.get("count")
        tvCount1.text = " $count"
    }
}


