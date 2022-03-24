package kg.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.homework61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySecondBinding

    companion object{
        const val KEY1 = "edit_text"
        const val KEY2 = "Tima"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edittextTwo.setText(intent.getStringExtra(KEY1))

        binding.btnBack.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(
                    KEY2,binding.edittextTwo.text.toString()
                )
            )
            finish()
        }
    }
}