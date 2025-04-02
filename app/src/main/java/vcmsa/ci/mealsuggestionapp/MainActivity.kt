package vcmsa.ci.mealsuggestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.KeyEventDispatcher.Component
import vcmsa.ci.mealsuggestionapp.R.id.GetMealSuggestionButton
import vcmsa.ci.mealsuggestionapp.R.id.MealAppearance
import vcmsa.ci.mealsuggestionapp.ui.theme.MealSuggestionAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting references to the EditText, Buttons, and TextView
        val inputName = findViewById<EditText>(R.id.edit_text_id)
        val submitButton = findViewById<Button>(R.id.GetMealSuggestionButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val resultText =findViewById<TextView>(R.id.MealAppearance)

        //when the "Submit" button is clicked
        submitButton.setOnClickListener {
            val inputName = inputName.text.toString().trim().lowercase()
            val mealSuggestion = when (inputName) {
                "Morning" -> "Morning, eggs, avocado"
                "Mid-Morning" -> "Mid-Morning, muesli"
                "afternoon" -> "Afternoon, yogurt with fruit"
                "afternoon snacks" -> "Afternoon snacks, cheese board"
                "dinner" -> "Dinner, steak and asparagus"
                "dessert" -> "dessert, vanilla ice cream"
                else -> null
            }

            if (GetMealSuggestionButton != null) {
                resultText.text = "Mealtime: ${mealSuggestion}"
                resultText.append("Meal options: ${mealSuggestion}")
            } else {
                Toast.makeText(
                    this, "Invalid input. Enter Time of day.", Toast.LENGTH_SHORT
                ).show()
                resultText.text = ""
            }
        }

        resetButton.setOnClickListener {
            inputName.text.clear()
            resultText.text=""

        }

    }

   

}