package com.ej.observertest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ej.observertest.databinding.FragmentThirdBinding
import com.ej.observertest.observer.MyTextEdit


class ThirdFragment : Fragment() {

    lateinit var binding: FragmentThirdBinding
    val args: ThirdFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var backCallback: OnBackPressedCallback = createBackCallback()
        requireActivity().onBackPressedDispatcher.addCallback(this, backCallback)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val myTextEdit = MyTextEdit()
        myTextEdit.addObserver {
            binding.sharedValueText.text = it.editStr
        }
        var myText = args.myText ?: ""
        myTextEdit.excuteEditText(myText)


        binding.frag3EditButton.setOnClickListener {
            val myData = binding.frag3EditValueText.text.toString()
            myTextEdit.excuteEditText(myData)
        }
    }

    private fun createBackCallback(): OnBackPressedCallback {
        var backCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val myText = binding.sharedValueText.text.toString()
                val action = ThirdFragmentDirections.actionThirdFragmentToSecondFragment(myText)
                findNavController().navigate(action)
            }
        }
        return backCallback
    }
}