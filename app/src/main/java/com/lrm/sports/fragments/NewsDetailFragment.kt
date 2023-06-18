package com.lrm.sports.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lrm.sports.SportsViewModel
import com.lrm.sports.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    private val sportsViewModel: SportsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            val action = NewsDetailFragmentDirections.actionNewsDetailFragmentToSportsListFragment()
            findNavController().navigate(action)
        }

        sportsViewModel.currentSport.observe(viewLifecycleOwner) {
            binding.titleDetail.text = getString(it.titleResourceId)
            binding.sportsImageDetail.setImageResource(it.sportsImageBanner)
        }
    }

}