package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentCuriosityPhotosBinding

class CuriosityPhotosFragment : Fragment() {

    private var _binding: FragmentCuriosityPhotosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCuriosityPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

}