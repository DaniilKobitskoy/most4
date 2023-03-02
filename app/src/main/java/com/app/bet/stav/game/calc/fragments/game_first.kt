package com.app.bet.stav.game.calc.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.app.bet.stav.game.calc.bindings
import com.app.bet.stav.game.calc.databinding.FragmentGameFirstBinding


class game_first : Fragment() {
lateinit var binding : FragmentGameFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentGameFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.out.setOnClickListener {
            val menu = menu()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, menu).commit()


        }
        binding.imageView9.setOnClickListener {

            val next = menu()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, next).commit()

        }

        binding.numBtn.setOnClickListener {

            val wewfrgtwerfsfwe = 10 // default bet is 10
            val effrwgerfrfdfsf = (1..10).random()
            val wrefdsefrfdfsffsdf = EditText(requireContext())
            wrefdsefrfdfsffsdf.inputType = InputType.TYPE_CLASS_NUMBER
            AlertDialog.Builder(requireContext())
                .setTitle("Place your bet!")
                .setMessage("How much do you want to bet?")
                .setView(wrefdsefrfdfsffsdf)
                .setPositiveButton("OK") { _, _ ->

                    val guess1 = wrefdsefrfdfsffsdf.text.toString()
                    if (guess1.length > 0){
                        val guess = wrefdsefrfdfsffsdf.text.toString().toInt()
                        if (guess in 1..10) {
                            if (guess == effrwgerfrfdfsf) {
                                binding.res.text =
                                    "You guessed $guess and the number was $effrwgerfrfdfsf. You won ${wewfrgtwerfsfwe * 2}!"
                            } else {
                                binding.res.text =
                                    "You guessed $guess and the number was $effrwgerfrfdfsf. You lost $wewfrgtwerfsfwe."
                            }
                        } else {
                            binding.res.text =
                                "Invalid guess. Please enter a number between 1 and 10."
                        }
                }
                    else{
                        binding.res.text =
                            "Invalid guess. Please enter a number between 1 and 10."
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()


        }

    }

    companion object {

        fun newInstance() =
            game_first()
    }
}