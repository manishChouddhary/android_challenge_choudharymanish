package com.manish.carshopee.main.viewcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.manish.carshopee.R
import com.manish.carshopee.carfindconfig.viewcomponent.CarMainTypeFragment
import com.manish.carshopee.carfindconfig.viewcomponent.CarManufacturerFragment
import com.manish.carshopee.component.BaseFragment
import com.manish.carshopee.databinding.MainConfigFragmentBinding

class MainConfigFragment : BaseFragment() {
    private var _binding: MainConfigFragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var container: () -> Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainConfigFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewListeners()
    }

    private fun setViewListeners() {
        binding.layoutCarManufacturerSearch.onEdit { goToManufacturerSelection() }
        binding.layoutCarMainTypeSearch.onEdit { goToCarTypeSelection() }
    }

    private fun goToCarTypeSelection() {
        sharedElementReturnTransition =
            TransitionInflater.from(requireActivity())
                .inflateTransition(R.transition.element_transition)
        val fragment = CarMainTypeFragment()
        fragment.sharedElementEnterTransition =
            TransitionInflater.from(requireActivity())
                .inflateTransition(R.transition.element_transition)
        ViewCompat.setTransitionName(
            binding.layoutCarMainTypeSearch,
            getString(R.string.search_transition_from)
        )
        with(requireActivity().supportFragmentManager.beginTransaction()) {
            addToBackStack(this@MainConfigFragment::class.java.canonicalName)
            replace(
                container.invoke(),
                fragment,
                CarMainTypeFragment::class.java.canonicalName
            )
            addSharedElement(
                binding.layoutCarMainTypeSearch,
                getString(R.string.search_transition_to)
            )
            commit()
        }
    }

    private fun goToManufacturerSelection() {
        sharedElementReturnTransition =
            TransitionInflater.from(requireActivity())
                .inflateTransition(R.transition.element_transition)
        val fragment = CarManufacturerFragment()
        fragment.sharedElementEnterTransition =
            TransitionInflater.from(requireActivity())
                .inflateTransition(R.transition.element_transition)
        ViewCompat.setTransitionName(
            binding.layoutCarManufacturerSearch,
            getString(R.string.search_transition_from)
        )
        with(requireActivity().supportFragmentManager.beginTransaction()) {
            replace(
                container.invoke(),
                fragment,
                CarManufacturerFragment::class.java.canonicalName
            )
            addToBackStack(this@MainConfigFragment::class.java.canonicalName)
            addSharedElement(
                binding.layoutCarManufacturerSearch,
                getString(R.string.search_transition_to)
            )
            commit()
        }
    }
}