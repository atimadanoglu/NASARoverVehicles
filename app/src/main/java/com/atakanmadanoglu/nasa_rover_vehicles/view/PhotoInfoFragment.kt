package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.atakanmadanoglu.nasa_rover_vehicles.R
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.FragmentPhotoInfoBinding
import com.atakanmadanoglu.nasa_rover_vehicles.model.Photo
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PhotoInfoFragment(
    private val photo: Photo
) : DialogFragment() {

    private var _binding: FragmentPhotoInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            _binding = FragmentPhotoInfoBinding.inflate(layoutInflater)
            val view = binding.root
            binding.photo = photo
            Glide.with(requireContext()).load(photo.img_src).into(binding.imageView)
            val materialDialog = MaterialAlertDialogBuilder(requireContext())
                .setView(view)
                .setPositiveButton(R.string.okay) { _, _ -> }
                .create()
            materialDialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}