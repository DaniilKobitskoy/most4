package com.app.bet.stav.game.calc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app.bet.stav.game.calc.R
import com.app.bet.stav.game.calc.bindings
import com.app.bet.stav.game.calc.databinding.FragmentGameBlitz1Binding
import com.app.bet.stav.game.calc.databinding.FragmentGameBlitz8Binding


class game_blitz8 : Fragment() {
    lateinit var binding: FragmentGameBlitz8Binding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBlitz8Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button19.setOnClickListener {

            val next = game_blitz1()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, next).commit()

        }
        binding.button20.setOnClickListener {

            Toast.makeText(requireContext(), "Lose", Toast.LENGTH_SHORT).show()

        }
        binding.imageView.setOnClickListener {

            val next = menu()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, next).commit()

        }
    }

    companion object {

        fun newInstance() =
            game_blitz8()
    }
}