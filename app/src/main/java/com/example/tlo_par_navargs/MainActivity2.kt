package com.example.tlo_par_navargs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tlo_par_navargs.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding2 : ActivityMain2Binding

    private var data1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding2 = DataBindingUtil.setContentView(this,
                R.layout.activity_main2)

        binding2.bOdbierz.setOnClickListener {
            data1 = intent.getIntExtra("DATA1",0)
            binding2.odJeden.setText(data1.toString())
        }

        binding2.bOdeslij.setOnClickListener {
            intent.putExtra("DATA1", data1 + 200)
            setResult(111, intent)
            finish()
        }
    }
}