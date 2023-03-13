package com.example.tlo_par_navargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tlo_par_navargs.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var bindingMain : FragmentMainBinding
    private var liczba: Int = 0;

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

}