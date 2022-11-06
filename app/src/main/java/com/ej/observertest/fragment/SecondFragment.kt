package com.ej.observertest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ej.observertest.databinding.FragmentSecondBinding
import com.ej.observertest.observer.MyTextEdit


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    val args: SecondFragmentArgs by navArgs()

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
        binding = FragmentSecondBinding.inflate(inflater)
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

        binding.moveFragBtn3.setOnClickListener {
            createDialog(myText)
        }

    }

    private fun createDialog(myText: String) {
        val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(myText)
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Fragemnt3 이동")
            .setMessage("이동합니다")
            .setPositiveButton("이동") { dialog, id ->
                findNavController().navigate(action)
            }
        builder.show()
    }


    private fun createBackCallback(): OnBackPressedCallback {
        var backCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val myText = binding.sharedValueText.text.toString()
                val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment(myText)
                findNavController().navigate(action)
            }
        }
        return backCallback
    }
}