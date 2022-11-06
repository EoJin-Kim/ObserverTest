package com.ej.observertest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ej.observertest.databinding.FragmentFirstBinding
import com.ej.observertest.observer.MyTextEdit

class FirstFragment : Fragment() {

    val args: FirstFragmentArgs by navArgs()
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moveFrag2Btn.setOnClickListener {
            val myData = binding.sharedValueText.text.toString()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(myData)
            findNavController().navigate(action)
        }
        val myTextEdit = MyTextEdit()
        myTextEdit.addObserver {
            binding.sharedValueText.text = it.editStr
        }

        binding.frag1EditButton.setOnClickListener {
            val myData = binding.frag1EditValueText.text.toString()
            myTextEdit.excuteEditText(myData)
        }

        var myText = args.myText ?: ""
        myTextEdit.excuteEditText(myText)


    }
}