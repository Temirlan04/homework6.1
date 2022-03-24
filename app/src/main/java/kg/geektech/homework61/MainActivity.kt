package kg.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var register:ActivityResultLauncher<Intent>

    companion object{
        const val  KEY1 = "edit_text"
        const val KEY2 = "Tima"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnGo.setOnClickListener {
                if (edittextOne.text.toString().isEmpty()){
                    Toast.makeText(this@MainActivity, getString(R.string.isEmty), Toast.LENGTH_SHORT).show()
                }else{
                    Intent(this@MainActivity,SecondActivity::class.java).apply {
                        putExtra(KEY1,edittextOne.text.toString())
                        register.launch(this)

                    }
                }
            }
            register = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()

            ){result->
                binding.edittextOne.setText(result.data?.getStringExtra(KEY2))

            }
        }
    }
}