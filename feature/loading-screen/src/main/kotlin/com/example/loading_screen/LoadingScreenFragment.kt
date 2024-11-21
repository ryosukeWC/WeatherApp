package com.example.loading_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loading_screen.databinding.LoadingLayoutFragmentBinding

class LoadingScreenFragment : Fragment() {

    private lateinit var loadingBinding: LoadingLayoutFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadingBinding = LoadingLayoutFragmentBinding.inflate(layoutInflater)
        return loadingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}