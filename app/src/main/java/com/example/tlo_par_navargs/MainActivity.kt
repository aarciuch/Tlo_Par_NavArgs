package com.example.tlo_par_navargs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.tlo_par_navargs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == 111) {
            val a = it.data?.getIntExtra("DATA1", 0)
            Toast.makeText(applicationContext,
            "odebrano : ${a}", Toast.LENGTH_LONG).show()
            binding.liczba.setText(a.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.b2SecondActivity.setOnClickListener {
            if (binding.zParametrem.isChecked) {
                var inten1 = Intent(applicationContext, MainActivity2::class.java)
                val a  = binding.liczba.text.toString()
                inten1.putExtra("DATA1",a.toInt())
                getResult.launch(inten1)
            }
            else {
                var inten1 = Intent(applicationContext, MainActivity2::class.java)
                inten1.putExtra("DATA1", 3000)
                startActivity(Intent(inten1))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp()
    }
}
