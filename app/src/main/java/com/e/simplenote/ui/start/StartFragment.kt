//package com.e.simplenote.ui.start
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.ViewModelProvider
//import com.e.simplenote.R
//import com.e.simplenote.databinding.FragmentStartBinding
//import com.e.simplenote.utilits.APP_ACTIVITY
//import com.e.simplenote.utilits.TYPE_ROOM
//
//
//class StartFragment : Fragment() {
//
//    private var _binding: FragmentStartBinding? = null
//    private val binding get() = _binding!!
//
//    private lateinit var viewModel: StartFragmentViewModel
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//       // (requireActivity() as AppCompatActivity?)!!.supportActionBar!!.hide()
//
//
//        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
//
//        return binding.root
//    }
//
//
//    override fun onStart() {
//        super.onStart()
//        init()
//    }
//
//    private fun init() {
//        viewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
//        binding.btnEnter.setOnClickListener {
//            viewModel.initDatabase(TYPE_ROOM) {
//                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//}