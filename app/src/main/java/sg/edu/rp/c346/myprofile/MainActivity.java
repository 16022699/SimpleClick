package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText etTextName;
    EditText etTextGPA;
    RadioGroup rgGender;
    RadioButton rbMale;
    RadioButton rbFemale;
    CheckBox ckbLike;

    public MainActivity() {
        super();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Step 1a: Retrieve data input of the user
        String strName = etTextName.getText().toString();
        Float strGPA = Float.parseFloat(etTextGPA.getText().toString());
        int rbGender = rgGender.getCheckedRadioButtonId();
        Boolean cbID = ckbLike.isChecked();

        //Step 1b: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 1c: Obtain an instance of the Shared Preferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 1d: Add the key-value pair
        prefEdit.putString("name",strName);
        prefEdit.putFloat("GPA",strGPA);
        prefEdit.putInt("id", rbGender);
        prefEdit.putBoolean("check",cbID);
        //Step 1e: Call commit() method td save the changes into the Shared Preferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Step 2a: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2b: Retrieve the saved data with they key, name from the SharedPreferences object.
        String strName = prefs.getString("name", "");
        Float strGPA = prefs.getFloat("GPA", 0);
        int rbGender =prefs.getInt("Gender", 0);
        Boolean cbID =prefs.getBoolean("ID", false);
        //Step 2c: Update the UI element with the value.
        etTextName.setText(strName);
        etTextGPA.setText(Float.toString(strGPA));
        rgGender.check(rbGender);
        ckbLike.setChecked(cbID);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTextName = (EditText) findViewById(R.id.editTextName);
        etTextGPA = (EditText) findViewById(R.id.editTextGPA);
        rgGender =(RadioGroup)findViewById(R.id.RadioGroupGender);
        rbMale =(RadioButton)findViewById(R.id.radioButtonGenderMale);
        rbFemale =(RadioButton)findViewById(R.id.radioButtonGenderFemale);
        ckbLike = (CheckBox)findViewById(R.id.checkBoxLikeProgramming);

    }
}
