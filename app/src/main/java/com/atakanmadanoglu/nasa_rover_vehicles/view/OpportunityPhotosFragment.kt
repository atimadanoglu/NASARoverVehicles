package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.atakanmadanoglu.nasa_rover_vehicles.R
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentOpportunityPhotosBinding

class OpportunityPhotosFragment : Fragment() {

    private var _binding: FragmentOpportunityPhotosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOpportunityPhotosBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val filterOptions = resources.getStringArray(R.array.opportunityFilterOptions)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, filterOptions)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

}