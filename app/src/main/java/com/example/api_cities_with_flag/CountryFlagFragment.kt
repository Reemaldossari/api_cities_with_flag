package com.example.api_cities_with_flag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.api_cities_with_flag.databinding.FragmentCountryFlagBinding

class CountryFlagFragment : Fragment() {
    private var binding: FragmentCountryFlagBinding?=null
    private val sharedViewModel:FlagViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryFlagBinding.inflate(inflater,container,false)
        binding?.lifecycleOwner = this
        binding?.photosGrid?.adapter = PhotoGridAdapter()
        binding?.viweModel = sharedViewModel
        return binding?.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}