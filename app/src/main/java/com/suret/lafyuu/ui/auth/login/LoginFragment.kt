package com.suret.lafyuu.ui.auth.login

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                            val typeError = event.errorModel?.typeError
                            if (typeError == TypeError.EMAIL_PASSWORD_ERROR) {
                                usernameTextInputLayout.error = event.errorModel.message
                                passwordTextInputLayout.error = "Parol bos ola bilmez"
                            } else if (typeError == TypeError.EMAIL_ERROR) {
                                passwordTextInputLayout.error = null
                                usernameTextInputLayout.error = event.errorModel.message
                            } else if (typeError == TypeError.PASSWORD_ERROR) {
                                usernameTextInputLayout.error = null
                                passwordTextInputLayout.error = event.errorModel.message
                            } else if (typeError == TypeError.INVALID_EMAIL_ERROR) {
                                usernameTextInputLayout.error = event.errorModel.message
                                passwordTextInputLayout.error = null
                            }
                            progressBar.dismiss()
                        }
                        is AuthViewModel.Event.Success<*> ->{
                            progressBar.dismiss()
                            findNavController().navigate(R.id.action_login_to_nestedFragment)
                        }
                    }
                }
            }
        }

    }

//        loginBinding.registerTv.setOnClickListener {
//            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
//        }
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