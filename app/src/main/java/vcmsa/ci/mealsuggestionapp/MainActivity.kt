package vcmsa.ci.mealsuggestionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import vcmsa.ci.mealsuggestionapp.ui.theme.MealSuggestionAppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find UI elements by ID
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestMealButton = findViewById<Button>(R.id.suggestMealButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)

        // Set button click listener for meal suggestion
        suggestMealButton.setOnClickListener {
            val timeText = timeInput.text.toString().trim().lowercase()

            // Validate input
            if (timeText.isEmpty()) {
                mealSuggestion.text = "Please enter a time of day (e.g., Morning, Mid-morning, Afternoon, Dinner)."
                return@setOnClickListener
            }

            // Get meal suggestion based on time of day
            val meal = getMealSuggestion(timeText)
            mealSuggestion.text = meal
        }

        // "Reset" button is clicked
        resetButton.setOnClickListener {
            timeInput.text.clear() // Clears input field
            mealSuggestion.text = "Your meal will appear here!" // Resets meal suggestion text
        }
    }

    /**
     * Determines the meal suggestion based on the time of day input.
     * @param timeOfDay - The time of day as a string (e.g., "morning", "afternoon").
     * @return A meal suggestion as a string.
     */
    private fun getMealSuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "morning" -> getRandomMeal(
                "Pancakes with maple syrup ",
                "Scrambled eggs with toast and avocado ",
                "Smoothie bowl with fresh fruits "
            )

            "mid-morning" -> getRandomMeal(
                "Yogurt with granola and honey",
                "Avocado toast with poached eggs ",
                "Banana and peanut butter sandwich "
            )

            "afternoon" -> getRandomMeal(
                "Grilled chicken salad ",
                "Pasta with tomato sauce ",
                "Sushi rolls with soy sauce "
            )

            "dinner" -> getRandomMeal(
                "Steak with mashed potatoes ",
                "Vegetable stir-fry with rice ",
                "Grilled salmon with lemon butter"
            )

            else -> "Invalid input! Please enter Morning, Mid-morning, Afternoon, or Dinner."
        }
    }

    /**
     * Returns a random meal from the provided options.
     * @param options - Meal options as vararg strings.
     * @return A randomly selected meal.
     */
    private fun getRandomMeal(vararg options: String): String {
        return "Suggested Meal: " + options[Random.nextInt(options.size)]
    }
}