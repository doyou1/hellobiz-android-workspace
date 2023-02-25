package com.example.pedometeruiappsampling.fragment.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pedometeruiappsampling.databinding.FragmentSettingNotificationsBinding

class SettingChildNotificationsFragment : SettingChildBaseFragment() {

    private var _binding: FragmentSettingNotificationsBinding? = null
    private val binding get() = _binding!!
    private val TAG = this::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        private var instance: SettingChildBaseFragment? = null

        fun getInstance(): SettingChildBaseFragment {
            if (instance == null) {
                instance = SettingChildNotificationsFragment()
            }
            return instance!!
        }
    }
}