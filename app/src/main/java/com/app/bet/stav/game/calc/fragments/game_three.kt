package com.app.bet.stav.game.calc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.bet.stav.game.calc.bindings
import com.app.bet.stav.game.calc.databinding.FragmentGameThreeBinding


class game_three : Fragment() {
    private var ehgrwtfdgthyrtg: Int = 1000
lateinit var binding: FragmentGameThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.peopleBalance.text = "Your Balance: $ehgrwtfdgthyrtg"
        binding.imageView11.setOnClickListener {

            val next = menu()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, next).commit()

        }
        binding.btn2.setOnClickListener {

            val menu = menu()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, menu).commit()


        }


        binding.btn.setOnClickListener {
            val etyrgfgyertgs =  binding.ebittextAmou.text.toString().toIntOrNull()
            if (etyrgfgyertgs == null) {
                binding.txtres.text = "Invalid bet amount"
            } else if (etyrgfgyertgs > ehgrwtfdgthyrtg) {
                binding.txtres.text = "Not enough balance"
            } else {
                val refwadfgtwerfefrgt = (1..6).random()
                val etrwgyhtegrvety = (1..6).random()

                if (refwadfgtwerfefrgt == etrwgyhtegrvety) {
                    ehgrwtfdgthyrtg += etyrgfgyertgs * 6
                    binding.txtres.text = "You rolled a $refwadfgtwerfefrgt! You won ${etyrgfgyertgs * 6} credits!"
                } else {
                    ehgrwtfdgthyrtg -= etyrgfgyertgs
                    binding.txtres.text = "You rolled a $refwadfgtwerfefrgt! You lost $etyrgfgyertgs credits."
                }
                binding.peopleBalance.text = "Current Balance: $ehgrwtfdgthyrtg"
            }
            binding.ebittextAmou.text.clear()
        }




    }
    companion object {

        fun newInstance() =
            game_three()
    }
}