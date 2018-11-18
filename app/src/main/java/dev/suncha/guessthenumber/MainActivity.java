package dev.suncha.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText lowerEditText, upperEditText;
    Button generatorButton;
    int lowerNumber, higherNumber, randomNumber;    //Defining the variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining the views (Edit Texts and Buttons)
        lowerEditText = findViewById(R.id.editTextLower);
        upperEditText = findViewById(R.id.editTextHigher);
        generatorButton = findViewById(R.id.button);

        //Getting the inputs
        lowerNumber = Integer.parseInt(lowerEditText.getText().toString());
        higherNumber = Integer.parseInt(upperEditText.getText().toString());

        //Check that input for higher number is greater than input for lower number before generating random number
        //Make sure that the range is good enough for the game to be interesting
        //Once the two things above are accomplished, generate the random number when the button is clicked
    }
}
