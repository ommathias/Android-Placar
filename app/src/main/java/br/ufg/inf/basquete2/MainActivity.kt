package br.ufg.inf.basquete2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.ufg.inf.basquete2.R.*

class MainActivity : AppCompatActivity() {

    private var ptsA = 0
    private var ptsB = 0
    private lateinit var scoreA: TextView
    private lateinit var scoreB: TextView
    private lateinit var btn3pto: Button
    private lateinit var btn2pto: Button
    private lateinit var btn1pto: Button
    private lateinit var btn3ptoB: Button
    private lateinit var btn2ptoB: Button
    private lateinit var btn1ptoB: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        scoreA = findViewById(id.tv_placarA)
        scoreB = findViewById(id.tv_placarB)
        val botaoReset: Button = findViewById(id.bt_reset)
        btn3pto = findViewById(id.bt_3pto)
        btn2pto = findViewById(id.bt_2pto)
        btn1pto = findViewById(id.bt_1pto)
        btn3ptoB =  findViewById(id.bt_3ptoB)
        btn2ptoB = findViewById(id.bt_2ptoB)
        btn1ptoB = findViewById(id.bt_1ptoB)


        botaoReset.setOnClickListener() {
            ptsA = 0;
            ptsB = 0;
            updatePlacar()
        }


        btn3pto.setOnClickListener {
            addPto(scoreA, 3)
        }

        btn2pto.setOnClickListener {
            addPto(scoreA, 2)
        }

        btn1pto.setOnClickListener {
            addPto(scoreA, 1)
        }

        btn3ptoB.setOnClickListener {
            addPto(scoreB, 3)
        }

        btn2ptoB.setOnClickListener {
            addPto(scoreB, 2)
        }

        btn1ptoB.setOnClickListener {
            addPto(scoreB, 1)
        }
    }


    fun addPto(placar: TextView, points: Int) {
        if (placar.id == R.id.tv_placarA) {
            ptsA += points
            placar.text = ptsA.toString()
        }
        else if (placar.id == R.id.tv_placarB)
            ptsB += points
            placar.text = ptsB.toString()

    }



    fun updatePlacar() {
        scoreA.setText(ptsA.toString())
        scoreB.setText(ptsB.toString())

    }
}