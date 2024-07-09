package gcc.holywater.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelha.R
import com.example.jogodavelha.databinding.ActivityMainBinding

class Principal : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        //Matriz que representativa do jogo.
        val tabuleiro = arrayOf(
            arrayOf("A", "B", "C"),
            arrayOf("D", "E", "F"),
            arrayOf("G", "H", "I")
        )

        //Declara o player 1.
        var playeratual = "o"

        //Função que roda o código.
        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
        }

        //Função do Player atual
        fun buttonClick(view: View) {

            //Representação do Player.
            val buttonSelecionado = view as Button

            //Declaração de cada turno.
            buttonSelecionado.text = playeratual

            //Usa o id do botão selecionado para declarar o turno de cada Player.
            when (buttonSelecionado.id) {
                binding.buttonum.id -> tabuleiro[0][0] = playeratual
                binding.buttondois.id -> tabuleiro[0][1] = playeratual
                binding.buttontres.id -> tabuleiro[0][2] = playeratual
                binding.buttonquatro.id -> tabuleiro[1][0] = playeratual
                binding.buttoncinco.id -> tabuleiro[1][1] = playeratual
                binding.buttonseis.id -> tabuleiro[1][2] = playeratual
                binding.buttonsete.id -> tabuleiro[2][0] = playeratual
                binding.buttonoito.id -> tabuleiro[1][1] = playeratual
                binding.buttonnove.id -> tabuleiro[2][2] = playeratual
            }

            var vencedor = verificaVencedor(tabuleiro)

            if (!vencedor.isNullOrBlank()) {
                Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Principal::class.java)
            }
            //Turno de qual player
            if (playeratual.equals("X")) {
                //se o primeiro Player for "X" então o outro Player é definido como "O"
                buttonSelecionado.setBackgroundResource(R.drawable.asuka2)
                playeratual = "O"
            } else {
                //Porque senão o player "O" sera definido como "X".
                buttonSelecionado.setBackgroundResource(R.drawable.rei2)
                playeratual = "X"
            }
            buttonSelecionado.isEnabled = false
        }
        //Função para declaração do vencedor.
        fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
            //Verificacao das linhas e colunas.
            for (i in 0 until 3) {
                //Verifica os itens iguais das linhas.
                if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                    return tabuleiro[i][0]
                }
                //Verifica os itens iguais das colunas.
                if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                    return tabuleiro[0][i]
                }
            }
            return null
        }
    }

