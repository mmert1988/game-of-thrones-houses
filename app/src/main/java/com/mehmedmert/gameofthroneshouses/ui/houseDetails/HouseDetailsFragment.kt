package com.mehmedmert.gameofthroneshouses.ui.houseDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mehmedmert.gameofthroneshouses.databinding.FragmentHouseDetailsBinding

class HouseDetailsFragment : Fragment() {
    private var _binding: FragmentHouseDetailsBinding? = null
    private val binding get() = _binding!!

    private val houseDetailsViewModel: HouseDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHouseDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
