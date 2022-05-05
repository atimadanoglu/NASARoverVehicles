package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atakanmadanoglu.nasa_rover_vehicles.adapter.OpportunityPhotosAdapter
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentOpportunityPhotosBinding
import com.atakanmadanoglu.nasa_rover_vehicles.viewModel.OpportunityPhotosViewModel

class OpportunityPhotosFragment : Fragment() {
    private var _binding: FragmentOpportunityPhotosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: OpportunityPhotosViewModel by viewModels()
    private lateinit var adapter: OpportunityPhotosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOpportunityPhotosBinding.inflate(inflater, container, false)
        adapter = OpportunityPhotosAdapter(parentFragmentManager, requireContext())
        binding.recyclerView.adapter = adapter
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.photos.observe(viewLifecycleOwner) {
            adapter.submitList(it.photos)
        }
        viewModel.getPhotos()
        return binding.root
    }
}