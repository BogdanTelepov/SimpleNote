package com.e.simplenote.ui.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.simplenote.R
import com.e.simplenote.databinding.FragmentNoteBinding
import com.e.simplenote.model.AppNote
import com.e.simplenote.utilits.APP_ACTIVITY


class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NoteFragmentViewModel
    private lateinit var currentAppNote: AppNote


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        currentAppNote = arguments?.getSerializable("note") as AppNote
        return binding.root
    }


    private fun init() {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
        binding.noteTitle.text = currentAppNote.name
        binding.noteText.text = currentAppNote.text
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_delete_note -> {
                viewModel.delete(currentAppNote) {
                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
            }
        }

        return super.onOptionsItemSelected(item)
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