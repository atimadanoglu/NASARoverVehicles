package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atakanmadanoglu.nasa_rover_vehicles.adapter.SpiritPhotosAdapter
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentSpiritPhotosBinding
import com.atakanmadanoglu.nasa_rover_vehicles.viewModel.SpiritPhotosViewModel

class SpiritPhotosFragment : Fragment() {

    private var _binding: FragmentSpiritPhotosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SpiritPhotosViewModel by viewModels()
    private lateinit var adapter: SpiritPhotosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSpiritPhotosBinding.inflate(inflater, container, false)
        adapter = SpiritPhotosAdapter(parentFragmentManager, requireContext())
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