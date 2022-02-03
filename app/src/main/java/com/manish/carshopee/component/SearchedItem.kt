package com.manish.carshopee.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.manish.carshopee.R
import com.manish.carshopee.databinding.ItemSearchedBinding

class SearchedItem(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {
    private var _binding: ItemSearchedBinding? = null
    private val binding get() = _binding!!
    private var mainType: String? = ""
    private var manufacturer: String? = ""

    init {
        _binding = ItemSearchedBinding.inflate(LayoutInflater.from(context), this, true)
        context.obtainStyledAttributes(attrs, R.styleable.SearchedItem).apply {
            manufacturer = getString(R.styleable.SearchedItem_manufacturer) ?: ""
            setManufacture(manufacturer!!)
            mainType = getString(R.styleable.SearchedItem_mainCarType) ?: ""
            setMainCarType(mainType!!)
            checkGuide()
        }.recycle()
    }

    private fun checkGuide() {
        binding.guideline.setGuidelinePercent(
            when {
                manufacturer.isNullOrEmpty() -> 0.0f
                mainType.isNullOrEmpty() -> 1.0f
                (mainType!!.isNotEmpty() && manufacturer!!.isNotEmpty()) -> 0.5f
                else -> 0.5f
            }
        )
    }

    private fun setMainCarType(mainType: String) {
        binding.tvMainType.text = mainType
    }

    private fun setManufacture(manufacturer: String) {
        binding.tvManufacturer.text = manufacturer
    }

    override fun isInEditMode(): Boolean {
        return false
    }
}