package com.example.tlo_par_navargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.tlo_par_navargs.databinding.FragmentMainBinding
import com.example.tlo_par_navargs.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    lateinit var bindingSecond: FragmentSecondBinding
    private val args : SecondFragmentArgs by navArgs<SecondFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingSecond = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second,
            container,
            false)

        bindingSecond.liczba.text = "0"

        return bindingSecond.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val liczbaIn1 = args.par
        val liczbaIn2 = arguments
        if (liczbaIn2 != null) {
            bindingSecond.liczba.text = String.format("$liczbaIn1\n${liczbaIn2.getInt("par")}")

        }

    }

}