package com.e.simplenote.ui.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.simplenote.R
import com.e.simplenote.databinding.FragmentAddNewNoteBinding
import com.e.simplenote.model.AppNote
import com.e.simplenote.utilits.APP_ACTIVITY


class AddNewNoteFragment : Fragment() {

    private var _binding: FragmentAddNewNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AddNewNoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    private fun init() {
        viewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val name = binding.editNoteTitle.toString().trim()
            val text = binding.editNoteText.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Введите имя заметки", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insert(AppNote(name = name, text = text)) {
                    APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}