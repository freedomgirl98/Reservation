package sg.edu.rp.c346.id19036308.reservation;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button  btnReserve, btnReset;
    EditText etName,etMobileNumber, etAmtPpl;
    CheckBox cbSmokingArea;
    DatePicker dp;
    TimePicker tp;
    TextView confirmMsg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbSmokingArea = findViewById(R.id.checkBoxSmokingArea);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);
        etName = findViewById(R.id.editTextName);
        etMobileNumber = findViewById(R.id.editTextMobileNum);
        etAmtPpl = findViewById(R.id.editTextAmtPpl);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        confirmMsg = findViewById(R.id.textViewConfirmMsg);
        dp.setMinDate(System.currentTimeMillis());


        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        if(cbSmokingArea.isChecked()){
            cbSmokingArea.setChecked(true);
        }
        else{
            cbSmokingArea.setChecked(false);
        }
        cbSmokingArea.setChecked(false);


        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etName.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Name not entered!", Toast.LENGTH_LONG).show();

                } else if (etMobileNumber.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, "Mobile Number not entered!", Toast.LENGTH_LONG).show();
                } else if(etAmtPpl.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, "Number of people not entered!", Toast.LENGTH_LONG).show();

                }
                else {
                    if(cbSmokingArea.isChecked()){
                        cbSmokingArea.setChecked(true);
                        etName.getText().toString();
                        String stringResponse = "Name:" + etName.getText().toString() + " " + "Mobile Number:" + etMobileNumber.getText().toString()
                                 + " Number of People:" + etAmtPpl.getText().toString() +" You have selected table in smoking area."+ " Date is " + dp.getDayOfMonth()  + "/" + (dp.getMonth()+1) + "/" + dp.getYear()
                                + " Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                        confirmMsg.setText(stringResponse);
                    } else{

                        etName.getText().toString();
                        String stringResponse = "Name:" + etName.getText().toString() + " " + "Mobile Number:" + etMobileNumber.getText().toString()
                                + " " + "Number of People:" + etAmtPpl.getText().toString() + " You have selected table in non-smoking area." + " Date is " + dp.getDayOfMonth()  + "/" + (dp.getMonth() +1) + "/" + dp.getYear()
                                + " Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                        confirmMsg.setText(stringResponse);
                    }



                    Toast.makeText(MainActivity.this, "SUBMITTED Thank YOU!  ", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                etName.setText("");
                etMobileNumber.setText("");
                etAmtPpl.setText("");
                cbSmokingArea.setChecked(false);
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (!(hourOfDay >= 8 && hourOfDay <= 20)) {
                    Toast.makeText(MainActivity.this, "reservation time to only between 8AM and 8:59PM ", Toast.LENGTH_LONG).show();
                    tp.setCurrentHour(8);
                    tp.setCurrentHour(0);
                }
            }
        });




    }
}
