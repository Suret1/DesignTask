package com.suret.lafyuu.ui.auth.register

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.suret.lafyuu.R
import com.suret.lafyuu.data.util.TypeError
import com.suret.lafyuu.databinding.FragmentRegisterBinding
import com.suret.lafyuu.ui.auth.viewmodel.AuthViewModel
import com.suret.lafyuu.util.ChangeStatusBarColor
import com.suret.lafyuu.util.PopUps
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var registerBinding: FragmentRegisterBinding
    private lateinit var progressBar: ProgressDialog
    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBinding.viewModel = authViewModel
        registerBinding.lifecycleOwner = viewLifecycleOwner
        progressBar = PopUps.progressDialog(requireActivity())

        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.status_bar_night,
            R.color.white
        )

        registerBinding.signTv.setOnClickListener {
            activity?.onBackPressed()
        }
        registerBinding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                authViewModel.registerFlow.collect { event ->
                    when (event) {
                        is AuthViewModel.Event.Loading -> {
                            progressBar.show()
                        }
                        is AuthViewModel.Event.Failure -> {
                            when (event.errorModel?.typeError) {
                                TypeError.FULLNAME_ERROR -> {
                                    fullUsernameInputLayout.error = event.errorModel.message
                                    emailInputLayout.error = null
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    passwordAgainTextInputLayout.error = null
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                }
                                TypeError.EMAIL_ERROR -> {
                                    emailInputLayout.error = event.errorModel.message
                                    fullUsernameInputLayout.error = null
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    passwordAgainTextInputLayout.error = null
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                }
                                TypeError.INVALID_EMAIL_ERROR -> {
                                    fullUsernameInputLayout.error = null
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    passwordAgainTextInputLayout.error = null
                                    emailInputLayout.error = event.errorModel.message
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                }
                                TypeError.PASSWORD_ERROR -> {
                                    fullUsernameInputLayout.error = null
                                    emailInputLayout.error = null
                                    passwordAgainTextInputLayout.error = null
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                    passwordTextInputLayout.error = event.errorModel.message
                                    passwordTextInputLayout.errorIconDrawable = null

                                }
                                TypeError.CONFIRM_PASS_ERROR -> {
                                    fullUsernameInputLayout.error = null
                                    emailInputLayout.error = null
                                    passwordAgainTextInputLayout.error = event.errorModel.message
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                }
                                TypeError.CONFIRM_PASS_SAME_ERROR -> {
                                    fullUsernameInputLayout.error = null
                                    emailInputLayout.error = null
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    passwordAgainTextInputLayout.error = event.errorModel.message
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                }
                                else -> {
                                    fullUsernameInputLayout.error = null
                                    emailInputLayout.error = null
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    passwordAgainTextInputLayout.error = null
                                    passwordAgainTextInputLayout.errorIconDrawable = null
                                    Toast.makeText(
                                        requireContext(),
                                        event.errorModel?.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            progressBar.dismiss()
                        }
                        is AuthViewModel.Event.RegisterSuccess-> {
                            progressBar.dismiss()
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.register_success),
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().navigate(R.id.action_login_to_nestedFragment)
                        }
                    }

                }
            }
        }


    }
}