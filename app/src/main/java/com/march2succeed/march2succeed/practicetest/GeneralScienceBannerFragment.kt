package com.march2succeed.march2succeed.practicetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.march2succeed.march2succeed.R
import com.march2succeed.march2succeed.databinding.FragmentGeneralScienceBannerBinding

class GeneralScienceBannerFragment : Fragment() {

    private lateinit var viewModel: PracticeTestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGeneralScienceBannerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_general_science_banner, container, false
        )
        binding.beginScienceTestBtn.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_generalScienceBannerFragment_to_generalScienceQuestionsFragment)
        }

        viewModel = ViewModelProvider(this).get(PracticeTestViewModel::class.java)
        return binding.root
    }
}
