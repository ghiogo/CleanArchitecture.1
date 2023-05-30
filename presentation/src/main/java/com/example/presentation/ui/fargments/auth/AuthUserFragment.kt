package com.example.presentation.ui.fargments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAuthUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthUserFragment : Fragment(R.layout.fragment_auth_user) {

    private val binding by viewBinding(FragmentAuthUserBinding::bind)
    private val viewModel by viewModels<AuthUserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRequest()
    }

    private fun setupRequest() = with(binding) {
        btnButton.setOnClickListener {
            if (name.text!!.isEmpty() && age.text!!.isEmpty() && surname.text!!.isEmpty()) {
                name.error = "Заполните поля"
                age.error = "Заполните поля"
                surname.error = "Заполните поля"
            } else if (age.text!!.isEmpty() && surname.text!!.isEmpty()) {
                age.error = "Заполните поля"
                surname.error = "Заполните поля"
            } else if (surname.text!!.isEmpty()) {
                surname.error = "Заполните поля"
            } else if (age.text!!.isEmpty()) {
                age.error = "Заполните поля"
            } else if (name.text!!.isEmpty()) {
                name.error = "Заполните поля"
            } else {
                val name = name.text.toString().trim()
                val age = age.text.toString().trim().toInt()
                val surname = surname.text.toString().trim()
                viewModel.authUser(name, age, surname)

                binding.name.setText("")
                binding.age.setText("")
                binding.surname.setText("")

                viewLifecycleOwner.lifecycleScope.launch {
                    delay(2000)
                    viewModel.getUser().apply {
                        binding.name.setText(this.name)
                        binding.age.setText(this.age)
                        binding.surname.setText(this.surname)
                    }
                }
                val action: NavDirections =
                    AuthUserFragmentDirections.actionAuthUserFragmentToDetailAuthUserFragment(
                        name,
                        age,
                        surname
                    )
                findNavController().navigate(action)
            }
        }
    }
}