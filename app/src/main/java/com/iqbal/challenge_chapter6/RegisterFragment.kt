package com.iqbal.challenge_chapter6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.iqbal.challenge_chapter6.databinding.FragmentRegisterBinding
import com.iqbal.challenge_chapter6.viewmodel.ViewModelUser
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root

    }

    fun addUser( username : String, password : String){
        var viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.postApiUser(password,username)
        viewModel.postLDUser.observe(viewLifecycleOwner,{
            if (it !=  null){
                Toast.makeText(context, "Registration Success!", Toast.LENGTH_SHORT).show()
            }
        })

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener{
            var editname = binding.edUsernameRegister.text.toString()
            var editpassword = binding.edRegisterPassword.text.toString()
            var editreapeatpass =  binding.edRegisterPasswordRepeat.text.toString()

            if (editpassword.equals(editreapeatpass)){

                addUser(editname,editpassword)

                Navigation.findNavController(requireView()).navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

    }


}