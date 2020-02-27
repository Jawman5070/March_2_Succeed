package com.march2succeed.march2succeed.practicetest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.march2succeed.march2succeed.R
import com.march2succeed.march2succeed.databinding.FragmentPrePracticeTestBinding

class PrePracticeTestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPrePracticeTestBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_pre_practice_test, container, false
        )
        binding.beginScienceBtn.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_prePracticeTestFragment_to_generalScienceBannerFragment)
        }

        return binding.root
        }
}

