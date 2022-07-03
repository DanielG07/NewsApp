package com.danielg07.newsapp.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielg07.newsapp.databinding.FragmentNewsBinding

private const val ARG_OBJECT = "object"

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            binding?.tvFragment?.text = getInt(ARG_OBJECT).toString()
        }
    }
}