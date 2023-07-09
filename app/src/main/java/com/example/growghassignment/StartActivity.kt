package com.example.growghassignment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class StartActivity : AppCompatActivity() {
    private var currentFragmentIndex = 0
    private val PREF_FIRST_LAUNCH = "pref_first_launch"
    private val KEY_FIRST_LAUNCH = "key_first_launch"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPreferences = getSharedPreferences(PREF_FIRST_LAUNCH, MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean(KEY_FIRST_LAUNCH, true)

        if (isFirstLaunch) {
            setContentView(R.layout.activity_start)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(KEY_FIRST_LAUNCH, false)
            editor.apply()

            if (savedInstanceState == null) {
                navigateToFragment(currentFragmentIndex)
            }
        } else {
            navigateToMainActivity()
        }
    }

    private fun navigateToFragment(index: Int) {
        val fragment: Fragment = when (index) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> FragmentOne()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    class FragmentOne : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_one, container, false)

            val nextButtonOne = view.findViewById<Button>(R.id.next)
            nextButtonOne.setOnClickListener {
                (requireActivity() as StartActivity).navigateToFragment(1)
            }

            val skipButton = view.findViewById<Button>(R.id.skip)
            skipButton.setOnClickListener {
                (requireActivity() as StartActivity).navigateToMainActivity()
            }

            return view
        }
    }

    class FragmentTwo : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_two, container, false)

            val nextButtonTwo = view.findViewById<Button>(R.id.next2)
            nextButtonTwo.setOnClickListener {
                (requireActivity() as StartActivity).navigateToFragment(2)
            }

            val skipButton = view.findViewById<Button>(R.id.skip2)
            skipButton.setOnClickListener {
                (requireActivity() as StartActivity).navigateToMainActivity()
            }

            return view
        }
    }

    class FragmentThree : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_three, container, false)

            val readyButton = view.findViewById<Button>(R.id.ready)
            readyButton.setOnClickListener {
                (requireActivity() as StartActivity).navigateToMainActivity()
            }

            val skipButton = view.findViewById<Button>(R.id.skip3)
            skipButton.setOnClickListener {
                (requireActivity() as StartActivity).navigateToMainActivity()
            }

            return view
        }
    }
}
