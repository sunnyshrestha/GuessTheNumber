package dev.suncha.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText lowerEditText, upperEditText;
    Button generatorButton;
    int lowerNumber, higherNumber, randomNumber;    //Defining the variables
    private  static int OPTIMUM_RANGE=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining the views (Edit Texts and Buttons)
        lowerEditText = findViewById(R.id.editTextLower);
        upperEditText = findViewById(R.id.editTextHigher);
        generatorButton = findViewById(R.id.button);

        //This code gets triggered when the Generate Random Number button is clicked
        generatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Convert EditText entries to integer avoiding number format exception
                try{
                    lowerNumber = Integer.parseInt(String.valueOf(lowerEditText.getText()));
                }catch (NumberFormatException nfe){
                    lowerNumber = 0;
                }

                try{
                    higherNumber = Integer.parseInt(String.valueOf(upperEditText.getText()));
                }catch (NumberFormatException nfe){
                    higherNumber=0;
                }

                //Check for null entries
                if(checkForNullEntries(lowerEditText,upperEditText)){
                    //If the fields are not empty, do the following:
                    //Make sure that the range is good enough for the game to be interesting
                    if(rangeOfNumbers(lowerNumber,higherNumber)>=OPTIMUM_RANGE){
                        //Generate random number
                        randomNumber = generateRandomNumber(lowerNumber,higherNumber);
                        Log.d("Random number = ", Integer.toString(randomNumber));
                    }else if(lowerNumber == higherNumber){
                        Toast.makeText(getApplicationContext(),R.string.cannotBeEqual,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),R.string.notInteresting,Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private int generateRandomNumber(int lowerNumber, int higherNumber) {
        Random rand = new Random();
        int randomNum = rand.nextInt((higherNumber-lowerNumber)+1)+lowerNumber;
        return randomNum;
    }

    //Calculate the absolute value of range
    private int rangeOfNumbers(int lowerNumber, int higherNumber) {
        return (Math.abs(lowerNumber-higherNumber));
    }

    private boolean checkForNullEntries(EditText lowerEditText, EditText upperEditText) {
        if(lowerEditText.getText().toString().matches("")|| upperEditText.getText().toString().matches("")){    //Check if the fields for lower and upper range are empty
            Toast.makeText(this,R.string.nullEntry,Toast.LENGTH_SHORT).show();                                       // Throw a toast message if the fields are empty
            return false;
        }
        return  true;
    }
}
