package gcc.holywater.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.example.jogodavelha.databinding.ActivityMainBinding

import kotlin.random.Random

class Bot {

    class MainActivity : AppCompatActivity() {
        //Variável de ligação.
        private lateinit var binding: ActivityMainBinding

        //Matriz que representa o tabuleiro.
        val tabuleiro = arrayOf(
            arrayOf("A", "B", "C"),
            arrayOf("D", "E", "F"),
            arrayOf("G", "H", "I")
        )
        //Entrada: savedInstanceState.
        override fun onCreate(savedInstanceState: Bundle?) {
            //Modifica o layout usando o binding.
            binding = ActivityMainBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(binding.root) //Define o layout Activity como padrão do binding.
        }

        //Função do botão pressionado.
        //entrada: view.
        fun buttonClick(view: View){
            // Converte a view recebida para um botão.
            val buttonSelecionado = view as Button

            buttonSelecionado.text = "X"
            buttonSelecionado.setBackgroundResource(com.example.jogodavelha.R.drawable.asuka1)
            //Desativa o botão.
            buttonSelecionado.isEnabled = false
            //Atualiza o tabuleiro com X na posição correspondente.
            when(buttonSelecionado.id){

                binding.buttonum.id -> tabuleiro[0][1] = "X"
                binding.buttondois.id -> tabuleiro[0][2] = "X"
                binding.buttontres.id -> tabuleiro[1][0] = "X"
                binding.buttonquatro.id -> tabuleiro[1][1] = "X"
                binding.buttoncinco.id -> tabuleiro[1][2] = "X"
                binding.buttonseis.id -> tabuleiro[2][0] = "X"
                binding.buttonsete.id -> tabuleiro[2][1] = "X"
                binding.buttonoito.id -> tabuleiro[2][2] = "X"
                binding.buttonnove.id -> tabuleiro[0][0] = "X"
            }
            //Gera posições aleatórias para o próximo movimento do bot.
            var rX = Random.nextInt(0, 3)
            var rY = Random.nextInt(0, 3)
            //Tentativa de encontrar uma posição vazia no tabuleiro.
            var i = 0
            while (i < 9) {
                rX = Random.nextInt(0, 3)
                rY = Random.nextInt(0, 3)

                if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                    break
                }
                i++
            }
            tabuleiro[rX][rY] = "O"
            buttonSelecionado.setBackgroundResource(com.example.jogodavelha.R.drawable.rei1)
            //Converte as posições.
            val posicao = rX * 3 + rY
            //Atualiza o texto e estado dos botões.
            when(posicao){
                1 -> {
                    binding.buttonum.text = "O"
                    binding.buttonum.isEnabled = false
                }
                2 -> {
                    binding.buttondois.text = "O"
                    binding.buttondois.isEnabled = false
                }
                3 -> {
                    binding.buttontres.text = "O"
                    binding.buttontres.isEnabled = false
                }
                4 -> {
                    binding.buttonquatro.text = "O"
                    binding.buttonquatro.isEnabled = false
                }
                5 -> {
                    binding.buttoncinco.text = "O"
                    binding.buttoncinco.isEnabled = false
                }
                6 -> {
                    binding.buttonseis.text = "O"
                    binding.buttonseis.isEnabled = false
                }
                7 -> {
                    binding.buttonsete.text = "O"
                    binding.buttonsete.isEnabled = false
                }
                8 -> {
                    binding.buttonoito.text = "O"
                    binding.buttonoito.isEnabled = false
                }
                0 -> {
                    binding.buttonnove.text = "O"
                    binding.buttonnove.isEnabled = false
                }
            }
        }
        //Função para validação do player vencedor.
        fun verificaVencedor(tabuleiro: Array<Array<String>>):String?{
            //Verifica as linhas e colunas.
            for (i in 0 until 3 ){
                //Verifica os itens iguais na linha.
                if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro [i][2]){
                    return tabuleiro[i][0]
                }
                //Verifica os itens iguais na coluna.
                if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro [2][i]){
                    return tabuleiro[0][i]
                }
            }
            return null
        }
    }


}