package com.manish.carshopee.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.manish.carshopee.R
import com.manish.carshopee.databinding.SearchCardBinding

class SearchModelView(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {
    private var _binding: SearchCardBinding? = null
    private val binding get() = _binding!!

    init {
        _binding = SearchCardBinding.inflate(LayoutInflater.from(context), this, true)
        context.obtainStyledAttributes(attrs, R.styleable.SearchModelView).apply {
            val hint = getString(R.styleable.SearchModelView_search_hint) ?: ""
            val showSearch = getBoolean(R.styleable.SearchModelView_showSearch, false)
            setSearchIcon(showSearch)
            setHint(hint)
            setListeners()
        }.recycle()
    }

    fun setSearchIcon(showSearch: Boolean) {
        binding.etSearch.setCompoundDrawables(
            if (showSearch) ContextCompat.getDrawable(
                context,
                R.drawable.ic_search
            ) else null, null, null, null
        )
    }

    private fun setListeners() {
        binding.ivClearDrugSearchText.setOnClickListener {
            binding.etSearch.text.clear()
            binding.ivClearDrugSearchText.gone()
        }
    }

    fun onEdit(perform: () -> Unit) {
        binding.etSearch.isFocusable = false
        binding.etSearch.setOnClickListener { perform.invoke() }
    }

    override fun isInEditMode(): Boolean {
        return false
    }

    fun requestEditFocus() {
        binding.etSearch.requestFocus()
        KeyboardUtils.showKeyboard(binding.etSearch)
    }

    fun setHint(hint: String) {
        binding.etSearch.hint = hint
    }
}