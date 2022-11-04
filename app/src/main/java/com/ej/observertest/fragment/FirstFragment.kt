package com.ej.observertest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ej.observertest.R
import com.ej.observertest.databinding.ActivityMainBinding
import com.ej.observertest.databinding.FragmentFirstBinding
import com.ej.observertest.observer.Aasdf

class FirstFragment : Fragment() {


    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        val test = Aasdf()
        binding.moveFrag2Btn.setOnClickListener {
            navController.navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment()
    }
}