package com.example.tlo_par_navargs

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.tlo_par_navargs.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var bindingMain : FragmentMainBinding
    private var liczba: Int = 0;
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingMain = DataBindingUtil.inflate(inflater,
        R.layout.fragment_main, container, false)

        sharedPref = context?.getSharedPreferences("EDIT", Context.MODE_PRIVATE)!!
        bindingMain.liczba.setText(sharedPref.getString("EDIT","").toString())
        Log.i("MAIN_FR","ON CREATE ")

        bindingMain.go2SecondB.setOnClickListener {
            if (bindingMain.liczba.text.toString().isNotEmpty()) {
                liczba = bindingMain.liczba.text.toString().toInt()
                val action = MainFragmentDirections.actionPar2Second()
                action.par = liczba
                it.findNavController().navigate(action)
            }

        }

        return bindingMain.root
    }

    override fun onDestroyView() {


       sharedPref = context?.getSharedPreferences("EDIT",Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("EDIT", bindingMain.liczba.text.toString())
            apply()
            Log.i("MAIN_FR","ON DESTROY VIEW")
        }
        super.onDestroyView()
    }
}