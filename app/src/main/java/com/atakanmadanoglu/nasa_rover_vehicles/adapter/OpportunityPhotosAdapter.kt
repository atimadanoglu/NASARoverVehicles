package com.atakanmadanoglu.nasa_rover_vehicles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.CuriosityViewHolderBinding
import com.atakanmadanoglu.nasa_rover_vehicles.model.Photo
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OpportunityPhotosAdapter(
    private val context: Context
): ListAdapter<Photo, OpportunityPhotosAdapter.ViewHolder>(OpportunityDiffUtil()) {
    class ViewHolder(private val binding: CuriosityViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun inflateFrom(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CuriosityViewHolderBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
        fun bind(photo: Photo, context: Context) {
            CoroutineScope(Dispatchers.Main).launch {
                Glide.with(context).load(photo.img_src).into(binding.imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.inflateFrom(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, context)
    }
}

class OpportunityDiffUtil: DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}
