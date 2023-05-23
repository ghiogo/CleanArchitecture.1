package com.example.cleanarchitecture1.presentation.ui.fargments.detailauth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentDetailAuthUserBinding

class DetailAuthUserFragment : Fragment(R.layout.fragment_detail_auth_user) {

    private val binding by viewBinding(FragmentDetailAuthUserBinding::bind)
    private val args by navArgs<DetailAuthUserFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initialize()
        setupListeners()
    }

    private fun getData() {
        binding.tvName.text = args.name
        binding.tvAge.text = args.age.toString()
        binding.tvSurname.text = args.surname
    }

    private fun initialize() {
        binding.tvName.isVisible = false
        binding.tvAge.isVisible = false
        binding.tvSurname.isVisible = false
    }

    private fun setupListeners() = with(binding) {
        btnDetail.setOnClickListener {
            tvName.isVisible = true
            tvAge.isVisible = true
            tvSurname.isVisible = true
            btnDetail.isVisible = false
            btnDoNotShowDetail.isVisible = true
        }
        btnDoNotShowDetail.setOnClickListener {
            tvName.isVisible = false
            tvAge.isVisible = false
            tvSurname.isVisible = false
            btnDetail.isVisible = true
            btnDoNotShowDetail.isVisible = false
        }
    }
}
