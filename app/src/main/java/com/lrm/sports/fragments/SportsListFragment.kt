package com.lrm.sports.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lrm.sports.SportsViewModel
import com.lrm.sports.adapter.SportsAdapter
import com.lrm.sports.databinding.FragmentSportsListBinding

class SportsListFragment : Fragment() {

    private var _binding: FragmentSportsListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private val sportsViewModel: SportsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportsListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.sportsRv
        recyclerView.adapter = SportsAdapter(requireContext()) {
            sportsViewModel.updateCurrentSport(it)
            val action = SportsListFragmentDirections.actionSportsListFragmentToNewsDetailFragment()
            this.findNavController().navigate(action)
        }
    }
}