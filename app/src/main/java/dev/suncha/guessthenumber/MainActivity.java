package dev.suncha.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


        //This code gets triggered when the Generate Random Number button is clicked
        generatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check for null entries
                do{
                    //If the fields are not empty, do the following:
                    //Check that input for higher number is greater than input for lower number before generating random number
                    //Make sure that the range is good enough for the game to be interesting
                    //Once the two things above are accomplished, generate the random number when the button is clicked
                } while (checkForNullEntries(lowerEditText, upperEditText));

            }
        });

    }

    private boolean checkForNullEntries(EditText lowerEditText, EditText upperEditText) {
        if(lowerEditText.getText().toString().matches("")|| upperEditText.getText().toString().matches("")){    //Check if the fields for lower and upper range are empty
            Toast.makeText(this,R.string.nullEntry,Toast.LENGTH_SHORT).show();                                       // Throw a toast message if the fields are empty
            return false;
        }
        return  true;

    }
}
