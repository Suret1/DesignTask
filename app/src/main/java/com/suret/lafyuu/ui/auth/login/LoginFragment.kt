package com.suret.lafyuu.ui.auth.login

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
import com.suret.lafyuu.data.model.TypeError
import com.suret.lafyuu.databinding.FragmentLoginBinding
import com.suret.lafyuu.ui.auth.viewmodel.AuthViewModel
import com.suret.lafyuu.util.ChangeStatusBarColor
import com.suret.lafyuu.util.PopUps
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var progressBar: ProgressDialog

    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding.viewModel = authViewModel
        loginBinding.lifecycleOwner = viewLifecycleOwner

        progressBar = PopUps.progressDialog(requireActivity())

        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.status_bar_night,
            R.color.white
        )
        loginBinding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                authViewModel.loginFlow.collect { event ->
                    when (event) {
                        is AuthViewModel.Event.Loading -> {
                            progressBar.show()
                        }
                        is AuthViewModel.Event.Failure -> {
                            when (event.errorModel?.typeError) {
                                TypeError.EMAIL_PASSWORD_ERROR -> {
                                    usernameTextInputLayout.error = event.errorModel.message
                                    passwordTextInputLayout.error =
                                        getString(R.string.password_not_empty)
                                    passwordTextInputLayout.errorIconDrawable = null
                                }
                                TypeError.EMAIL_ERROR -> {
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    usernameTextInputLayout.error = event.errorModel.message
                                }
                                TypeError.PASSWORD_ERROR -> {
                                    usernameTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                    passwordTextInputLayout.error = event.errorModel.message
                                }
                                TypeError.INVALID_EMAIL_ERROR -> {
                                    usernameTextInputLayout.error = event.errorModel.message
                                    passwordTextInputLayout.error = null
                                    passwordTextInputLayout.errorIconDrawable = null
                                }
                                else -> {
                                    passwordTextInputLayout.errorIconDrawable = null
                                    usernameTextInputLayout.error = null
                                    passwordTextInputLayout.error = null
                                    Toast.makeText(
                                        requireContext(),
                                        event.errorModel?.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            progressBar.dismiss()
                        }
                        is AuthViewModel.Event.Success<*> -> {
                            progressBar.dismiss()
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.login_success),
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().navigate(R.id.action_login_to_nestedFragment)
                        }
                    }
                }
            }
        }
        loginBinding.registerTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
//
//        loginBinding.signInBtn.setOnClickListener {
//
//            val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences(
//                Constants.userData,
//                Context.MODE_PRIVATE
//            )
//            val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
//            editor?.putBoolean(Constants.loginBoolean, true)
//            editor?.apply()
//            editor?.commit()
//            view.findNavController().navigate(R.id.action_login_to_nestedFragment)
//        }


}