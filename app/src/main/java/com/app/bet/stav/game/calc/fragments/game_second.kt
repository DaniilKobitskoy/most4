package com.app.bet.stav.game.calc.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.bet.stav.game.calc.bindings
import com.app.bet.stav.game.calc.databinding.FragmentGameSecondBinding
import kotlin.random.Random


class game_second : Fragment() {
lateinit var binding: FragmentGameSecondBinding
    private var sdfgerfdfvgrehy = 100
    private var grfgthdyjuki = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameSecondBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView10.setOnClickListener {

            val next = menu()
            var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, next).commit()

        }

        gfhnjgkigjhgf()
        binding.btnClick.setOnClickListener {
           var fvsrtgsfdvrsvf = binding.etMain.text.toString()
            grfgthdyjuki = fvsrtgsfdvrsvf.toInt()
            if (grfgthdyjuki > 0) {
                uiugyftdregthyjrtyj()
            } else {
                binding.res.text = "Please place a bet first."
            }
        }
        binding.quitButton.setOnClickListener {
        val menu = menu()
        var trans = requireFragmentManager().beginTransaction()
            trans.replace(bindings.gameView.id, menu).commit()


        }



    }



    private fun uiugyftdregthyjrtyj() {
        val werfarsfrer = Random.nextInt(2)
        if (werfarsfrer == 0) {
            zxcdsaefsdd()
        } else {
            kijuyhgfd()
        }
    }

    private fun zxcdsaefsdd() {
        sdfgerfdfvgrehy += grfgthdyjuki
        binding.res.text = "You won!"
        gfhnjgkigjhgf()
    }

    private fun kijuyhgfd() {
        sdfgerfdfvgrehy -= grfgthdyjuki
        binding.res.text = "You lost!"
        gfhnjgkigjhgf()
    }

    private fun gfhnjgkigjhgf() {
        binding.mTxt.text = "Money: $sdfgerfdfvgrehy"
        binding.btv.text = "Your Bet: $grfgthdyjuki"
    }


    companion object {

        fun newInstance() =
            game_second()
    }
}