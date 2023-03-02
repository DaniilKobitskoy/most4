package com.app.bet.stav.game.calc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.app.bet.stav.game.calc.R
import com.app.bet.stav.game.calc.bindings
import com.app.bet.stav.game.calc.databinding.FragmentGameCardBinding


class game_card : Fragment() {
  lateinit var binding: FragmentGameCardBinding
    private lateinit var fdsagdfgsdfadddasd: Array<Button>
    private lateinit var gfdefrsegthyegrfed: MutableList<Button>
    private lateinit var sfdjhsdfgsyfdhjfjksfsf: MutableList<Int>

    private var ghhgfdfghyjhgfv = 0
    private var hgfdfghjuikjhgfd = 0
    private var cvfbngfhgdfvdcs = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
binding.backs.setOnClickListener {

    var menu = menu()
    var next = requireFragmentManager().beginTransaction()
    next.replace(bindings.gameView.id, menu)
    next.commit()


}
        fdsagdfgsdfadddasd = arrayOf(binding.button1, binding.button2, binding.button3, binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9, binding.button10, binding.button11, binding.button12
        , binding.button13, binding.button14, binding.button15, binding.button16, binding.button17, binding.button18
        )
        gfdefrsegthyegrfed = mutableListOf()
        sfdjhsdfgsyfdhjfjksfsf = mutableListOf()

        gfdsfgfhygfdscfgh()
        binding.levelButton.setOnClickListener {
            if (ghhgfdfghyjhgfv == 0) {
                binding.levelButton.text = "Level 2"
                ghhgfdfghyjhgfv = 1
                hgfdfghjuikjhgfd = 9
                gfdsfgfhygfdscfgh()
//                for (i in buttons.indices) {
//                    buttons[i].setBackgroundResource(android.R.drawable.btn_default)
//                    buttons[i].tag = null
//                }
            } else {
                binding.levelButton.text = "Level 1"
                ghhgfdfghyjhgfv = 0
                hgfdfghjuikjhgfd = 9
                gfdsfgfhygfdscfgh()
//                for (i in buttons.indices) {
//                   buttons[i].setBackgroundResource(android.R.drawable.btn_default)
//                    buttons[i].tag = null
//                    buttons[i].text = ""
//                    buttons[i].isEnabled = true
//                }
            }
        }


    }

    private fun gfdsfgfhygfdscfgh() {
        cvfbngfhgdfvdcs = 0
        gfdefrsegthyegrfed.clear()
        sfdjhsdfgsyfdhjfjksfsf.clear()

        val fghyjukigfdfghy = getImageIds(ghhgfdfghyjhgfv)


        val shuffledImages = (fghyjukigfdfghy + fghyjukigfdfghy).shuffled()
        for (i in fdsagdfgsdfadddasd.indices) {
            if (i < fdsagdfgsdfadddasd.size){
                fdsagdfgsdfadddasd[i].tag = shuffledImages[i]
                fdsagdfgsdfadddasd[i].text = ""
                fdsagdfgsdfadddasd[i].isEnabled = true
                fdsagdfgsdfadddasd[i].setBackgroundResource(android.R.drawable.btn_default)

                fdsagdfgsdfadddasd[i].setOnClickListener {
                    ghtyfdtgrfefrgtdhy(it)
                }
            }
            else{
                binding.fghgrfsdfgyhfgdf.text = "Find all $hgfdfghjuikjhgfd pairs!"
            }

        }

        binding.fghgrfsdfgyhfgdf.text = "Find all $hgfdfghjuikjhgfd pairs!"
    }
    private fun ghtyfdtgrfefrgtdhy(view: View) {
        view as Button

        val fghjkjytrdcvbjhgfv = view.tag as Int

        view.setBackgroundResource(fghjkjytrdcvbjhgfv)
        view.text = ""

        gfdefrsegthyegrfed.add(view)
        sfdjhsdfgsyfdhjfjksfsf.add(fghjkjytrdcvbjhgfv)

        if (sfdjhsdfgsyfdhjfjksfsf.size == 2) {
            if (sfdjhsdfgsyfdhjfjksfsf[0] == sfdjhsdfgsyfdhjfjksfsf[1]) {
                // Images are paired, disable the buttons
                gfdefrsegthyegrfed.forEach {
                    it.isEnabled = false
                    it.text = "✓"
                }
                cvfbngfhgdfvdcs++

                if (cvfbngfhgdfvdcs == hgfdfghjuikjhgfd) {
                    binding.fghgrfsdfgyhfgdf.text = "Congratulations! You won!"
                } else {
                    binding.fghgrfsdfgyhfgdf.text = "Good job! Find ${hgfdfghjuikjhgfd - cvfbngfhgdfvdcs} more pairs."
                }
            } else {
                gfdefrsegthyegrfed.forEach {
                    it.setBackgroundResource(R.drawable.btn)
                    it.text = ""
                }
            }

            gfdefrsegthyegrfed.clear()
            sfdjhsdfgsyfdhjfjksfsf.clear()
        }
    }

    private fun getImageIds(level: Int): List<Int> {
        return when (level) {
            0 -> listOf(R.drawable.ball1, R.drawable.ball2, R.drawable.ball3, R.drawable.ball4, R.drawable.ball5, R.drawable.ball6,
                R.drawable.ball7, R.drawable.ball8, R.drawable.ball9)
            1 -> listOf(R.drawable.ball1, R.drawable.ball2, R.drawable.ball3, R.drawable.ball4, R.drawable.ball5, R.drawable.ball6,
                R.drawable.ball7, R.drawable.ball8, R.drawable.ball9)
            else -> emptyList()
        }
    }
    companion object {

        fun newInstance() =
            game_card()
    }
}