package com.example.orientation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_position1.*
import kotlinx.android.synthetic.main.fragment_position2.*


class Position2Fragment : Fragment(R.layout.fragment_position2) {
    override fun onStart() {
        super.onStart()
        var count = this.arguments?.get("count")
        tvCount2.text = "$count"
    }
}