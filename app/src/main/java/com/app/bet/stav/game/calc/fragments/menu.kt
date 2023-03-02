package com.app.bet.stav.game.calc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.bet.stav.game.calc.R
import com.app.bet.stav.game.calc.bindings
import com.app.bet.stav.game.calc.databinding.FragmentMenuBinding


class menu : Fragment() {

    lateinit var binding: FragmentMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

binding.button.setOnClickListener {
    val game1 = game_first()
    val post = requireFragmentManager().beginTransaction()
    post.replace(bindings.gameView.id, game1).commit()



}
        binding.button2.setOnClickListener {
            val game2 = game_second()
            val post = requireFragmentManager().beginTransaction()
            post.replace(bindings.gameView.id, game2).commit()



        }
        binding.button3.setOnClickListener {
            val game3 = game_three()
            val post = requireFragmentManager().beginTransaction()
            post.replace(bindings.gameView.id, game3).commit()



        }
        binding.button4.setOnClickListener {
            val game4 = game_blitz1()
            val post = requireFragmentManager().beginTransaction()
            post.replace(bindings.gameView.id, game4).commit()



        }

        binding.button22.setOnClickListener {
            val game5 = game_card()
            val post = requireFragmentManager().beginTransaction()
            post.replace(bindings.gameView.id, game5).commit()



        }

    }
    companion object {

        fun newInstance(param1: String, param2: String) =
            menu()
    }
}