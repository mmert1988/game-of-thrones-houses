package com.mehmedmert.gameofthroneshouses.ui.houseDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.mehmedmert.gameofthroneshouses.databinding.FragmentHouseDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HouseDetailsFragment : Fragment() {
    private var _binding: FragmentHouseDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: HouseDetailsFragmentArgs by navArgs()
    private val houseDetailsViewModel: HouseDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHouseDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titlesAdapter = TextAdapter()
        val seatsAdapter = TextAdapter()
        binding.titles.adapter = titlesAdapter
        binding.seats.adapter = seatsAdapter
        binding.titles.isNestedScrollingEnabled = false
        binding.seats.isNestedScrollingEnabled = false

        houseDetailsViewModel.fetchHouseDetails(args.id)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                houseDetailsViewModel.uiState.collect {
                    binding.name.text = it.name
                    binding.region.text = it.region
                    binding.words.text = it.words
                    titlesAdapter.submitList(it.titles)
                    seatsAdapter.submitList(it.seats)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
