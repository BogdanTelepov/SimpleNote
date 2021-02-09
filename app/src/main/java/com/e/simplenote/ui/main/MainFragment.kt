package com.e.simplenote.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.e.simplenote.R
import com.e.simplenote.databinding.FragmentMainBinding
import com.e.simplenote.model.AppNote
import com.e.simplenote.utilits.APP_ACTIVITY
import com.e.simplenote.utilits.TYPE_ROOM


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var _observerList: Observer<List<AppNote>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        init()
    }


    private fun init() {
        mAdapter = MainAdapter()
        recyclerView = binding.recyclerViewNoteList
        recyclerView.adapter = mAdapter
        _observerList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }

        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.allNotes.observe(viewLifecycleOwner, _observerList)

        binding.floatingBtn.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.allNotes.removeObserver(_observerList)
        recyclerView.adapter = null
    }


    companion object {
        fun click(appNote: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", appNote)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }


}