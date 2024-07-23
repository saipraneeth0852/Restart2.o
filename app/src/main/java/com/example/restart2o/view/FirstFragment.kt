package com.example.restart2o.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.restart2o.R
import com.example.restart2o.databinding.FragmentFirstBinding
import com.example.restart2o.viewmodel.CountViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val countViewModel: CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


        countViewModel.getMutableCount().observe(viewLifecycleOwner, Observer { set ->

            Log.i("Praneeth","Received value:"+set)
            Toast.makeText(view.context,"Received Value:"+set, Toast.LENGTH_SHORT).show()
            binding.textviewFirst.text="Count:"+set
            // Update the selected filters UI.

        })


        binding.incrementButton.setOnClickListener{
            countViewModel.increment()

        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


