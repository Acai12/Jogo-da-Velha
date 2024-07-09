package gcc.holywater.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.jogodavelha.databinding.ActivityMainBinding

class Ligacao : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

            binding.btrobo.setOnClickListener {
                val intent = Intent(this, ligacao::class.java)
                startActivity(intent)
            }

            binding.btjogadores.setOnClickListener {
                val intent = Intent(this, principal::class.java)
                startActivity(intent)
            }
            //Quando pressionado o botão inicia a atividade.
        }
    }
