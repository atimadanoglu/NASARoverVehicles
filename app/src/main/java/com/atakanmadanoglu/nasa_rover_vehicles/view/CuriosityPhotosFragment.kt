package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atakanmadanoglu.nasa_rover_vehicles.adapter.CuriosityPhotosAdapter
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentCuriosityPhotosBinding
import com.atakanmadanoglu.nasa_rover_vehicles.viewModel.CuriosityPhotosViewModel

class CuriosityPhotosFragment : Fragment() {

    private var _binding: FragmentCuriosityPhotosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CuriosityPhotosViewModel by viewModels()
    private lateinit var adapter: CuriosityPhotosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCuriosityPhotosBinding.inflate(inflater, container, false)
        adapter = CuriosityPhotosAdapter(requireContext())
        binding.recyclerView.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner) {
            adapter.submitList(it.photos)
        }
        viewModel.getPhotos()
        return binding.root
    }

}