package com.example.cleanarchitecture1.presentation.ui.fargments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentAuthUserBinding
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

    private fun setupRequest() {
        binding.btnButton.setOnClickListener {
            if (binding.name.text!!.isEmpty() && binding.age.text!!.isEmpty() && binding.surname.text!!.isEmpty()) {
                binding.name.error = "Заполните поля"
                binding.age.error = "Заполните поля"
                binding.surname.error = "Заполните поля"
            } else if (binding.age.text!!.isEmpty() && binding.surname.text!!.isEmpty()) {
                binding.age.error = "Заполните поля"
                binding.surname.error = "Заполните поля"
            } else if (binding.surname.text!!.isEmpty()) {
                binding.surname.error = "Заполните поля"
            } else if (binding.age.text!!.isEmpty()) {
                binding.age.error = "Заполните поля"
            } else if (binding.name.text!!.isEmpty()) {
                binding.name.error = "Заполните поля"
            } else {
                val name = binding.name.text.toString().trim()
                val age = binding.age.text.toString().trim().toInt()
                val surname = binding.surname.text.toString().trim()
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