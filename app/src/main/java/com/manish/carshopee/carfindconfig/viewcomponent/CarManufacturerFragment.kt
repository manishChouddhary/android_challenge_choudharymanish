package com.manish.carshopee.carfindconfig.viewcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.manish.carshopee.R
import com.manish.carshopee.component.BaseFragment
import com.manish.carshopee.databinding.MainConfigFragmentBinding
import com.manish.carshopee.databinding.SearchElementsBinding

class CarManufacturerFragment : BaseFragment() {
    private var _binding: SearchElementsBinding? = null
    private val binding get() = _binding!!
    private val carsViewModel by viewModels<CarsViewModel> { viewModelFactory }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchElementsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchBar.requestEditFocus()
        binding.searchBar.setHint(getString(R.string.search_manufacturer))
        binding.searchBar.setSearchIcon(false)
        carsViewModel.getCarsManufaturer()
    }
}