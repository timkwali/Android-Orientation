package com.example.orientation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_position1.*
import kotlinx.android.synthetic.main.fragment_position3.*


class Position3Fragment : Fragment(R.layout.fragment_position3) {
    override fun onStart() {
        super.onStart()
        var count = this.arguments?.get("count")
        tvCount3.text = "$count"
    }
}