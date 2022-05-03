package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atakanmadanoglu.nasa_rover_vehicles.R
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentPhotoInfoBinding

class PhotoInfoFragment : Fragment() {

    private var _binding: FragmentPhotoInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPhotoInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

}