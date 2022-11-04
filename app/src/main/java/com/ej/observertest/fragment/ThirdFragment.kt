package com.ej.observertest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ej.observertest.R
import com.ej.observertest.databinding.FragmentFirstBinding
import com.ej.observertest.databinding.FragmentSecondBinding
import com.ej.observertest.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {
    lateinit var binding : FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentThirdBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThirdFragment()
    }
}