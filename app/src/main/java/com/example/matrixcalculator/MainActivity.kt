package com.example.matrixcalculator

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.matrixcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as ProvideViewModel).provide()

        binding.diffButton.setOnClickListener {
            val command = DiffCommand(getFirstMatrix(), getSecondMatrix())
            viewModel.calculate(command)
        }

        binding.multiplyButton.setOnClickListener {
            val command = MultiplyCommand(getFirstMatrix(), getSecondMatrix())
            viewModel.calculate(command)
        }

        binding.sumButton.setOnClickListener {
            val command = SumCommand(getFirstMatrix(), getSecondMatrix())
            viewModel.calculate(command)
        }

        viewModel.liveData.observe(this) {
            it.showInfo(binding.answer)
        }

    }

    private fun getFirstMatrix(): MatrixEntity {
        val data = MutableList(2) { MutableList(2) { 0 } }
        data[0][0] = makeNumber(binding.matrix111)
        data[0][1] = makeNumber(binding.matrix112)
        data[1][0] = makeNumber(binding.matrix121)
        data[1][1] = makeNumber(binding.matrix122)
        return MatrixEntity(data)
    }

    private fun getSecondMatrix(): MatrixEntity {
        val data = MutableList(2) { MutableList(2) { 0 } }
        data[0][0] = makeNumber(binding.matrix211)
        data[0][1] = makeNumber(binding.matrix212)
        data[1][0] = makeNumber(binding.matrix221)
        data[1][1] = makeNumber(binding.matrix222)
        return MatrixEntity(data)
    }

    private fun makeNumber(editText: EditText): Int {
        return try {
            editText.text.toString().toInt()
        } catch (e: Exception) {
            0
        }
    }

}