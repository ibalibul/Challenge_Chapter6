package com.iqbal.challenge_chapter6

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import com.iqbal.challenge_chapter6.databinding.FragmentLoginBinding
import com.iqbal.challenge_chapter6.datastore.UserPreferencesRepository
import com.iqbal.challenge_chapter6.viewmodel.ViewModelUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

private const val TAG = "LoginFragment"

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var userPrefrences: UserPreferencesRepository
    lateinit var binding : FragmentLoginBinding
    lateinit var userViewModel : ViewModelUser
    lateinit var username : String
    lateinit var password : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Started...")

        userViewModel = ViewModelProvider(this)[ViewModelUser::class.java]

        userPrefrences = UserPreferencesRepository(requireContext())





        binding.btnLogin.setOnClickListener{

//            throw RuntimeException("Test Crash") // Force a crash

            GlobalScope.launch {
                userPrefrences.saveData(binding.edUsername.text.toString(), binding.edPassword.text.toString())
            }
            Handler(Looper.getMainLooper()).postDelayed({
                userPrefrences =  UserPreferencesRepository(requireContext())
                userPrefrences.userName.asLiveData().observe(viewLifecycleOwner) {
                    username = it.toString()
                    Toast.makeText(context, "Selamat Datang", Toast.LENGTH_SHORT).show()
                    if (it != null)
                        Navigation.findNavController(view)
                            .navigate(R.id.action_loginFragment_to_homeFragment)
                }
            }, 3000)
        }






        binding.txtRegister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.txtIndonesia.setOnClickListener{
            setLocale("id")
        }
        binding.txtEnglish.setOnClickListener{
            setLocale("en")
        }

    }

    fun setLocale(lang : String){
        val local = Locale(lang)
        val conf = resources.configuration
        conf.locale = local
        resources.updateConfiguration(conf,resources.displayMetrics)
        activity?.startActivity(Intent(activity,MainActivity::class.java))
    }


}