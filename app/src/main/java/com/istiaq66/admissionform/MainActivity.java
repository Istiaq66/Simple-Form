package com.istiaq66.admissionform;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Double[] arr1= {18d,19d,20d,21d,22d,23d,24d,25d,26d,27d,28d,29d,30d,31d,32d,33d,34d,35d,36d,37d,38d,39d,40d};
    Double[] arr2={3d,4d,5d,6d,7d};
    Double[] arr3={1d,2d,3d,4d,5d,6d,7d,8d,9d,10d,11d,12d};
    String[] arr4={"40-50","50-60","60-70","70-80","80-90","90-100"};
    ImageView ig;


    EditText et;
    Spinner sp11;
    Spinner sp22;
    Spinner sp33;
    Spinner sp44;

    int year;
    int month;
    int date;

    String eddata;
    TextView txt;

    CheckBox ch1,ch2,ch3,ch4;


    private RadioGroup radioSimGroup;
    private Button btnDisplay;
    private RadioButton radioSimButton;
    private RadioButton rd1,rd2;

    private  static final  int GALLERY_REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        sp11 = findViewById(R.id.sp);
        sp22 = findViewById(R.id.sp2);
        sp33 = findViewById(R.id.sp3);
        sp44 = findViewById(R.id.sp4);
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DATE);
        txt =findViewById(R.id.txt1);
        et = findViewById(R.id.ed1);
        btnDisplay = (Button) findViewById(R.id.button);



        addListenerOnButton();


        //--------------textview date pic---------------------


        txt.setInputType(InputType.TYPE_NULL);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        eddata =  (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        txt.setText(eddata);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });



        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*//way one to show by Toast status--
               StringBuffer result = new StringBuffer();
               result.append("Thanks : ").append(ch1.isChecked());
               result.append("\nThanks: ").append(ch2.isChecked());

               Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_LONG).show();
           */



                ch1=(CheckBox)findViewById(R.id.checkbox1);
                ch2=(CheckBox)findViewById(R.id.checkbox2);
                ch2=(CheckBox)findViewById(R.id.checkbox3);
                ch2=(CheckBox)findViewById(R.id.checkbox4);



                Intent intent = new Intent(MainActivity.this, Second_activity.class);


                if(ch1.isChecked()){
                    String result = "Football";
                    intent.putExtra("grade1", result);

                }
                if(ch2.isChecked()){
                    String result2 = "Cricket";

                    //if want to show same place
                    // intent.putExtra("grade1", result2);
                    //if want to show another view
                    intent.putExtra("grade2", result2);
                }
                if(ch1.isChecked()){
                    String result3 = "Tennis";
                    intent.putExtra("grade3", result3);

                }

                if(ch1.isChecked()){
                    String result4 = "Indoor games";
                    intent.putExtra("grade4", result4);

                }
                //  intent.putExtra("grade1", ch1.isChecked());
                //  intent.putExtra("grade2", ch2.isChecked());

                 String msg = et.getText().toString();

                intent.putExtra("dv1",msg);




                //--------------------------------------
                startActivity(intent);


            }
        });


        ArrayList<Double> a1 = new ArrayList<Double>();
        for (Double i:arr1)
        {

            a1.add(i);
        }

        ArrayAdapter<Double> adapter = new ArrayAdapter<Double>(this, android.R.layout.simple_spinner_dropdown_item,a1);

        sp11.setAdapter(adapter);




        ArrayList<Double> a2 = new ArrayList<Double>();
        for (Double j:arr2)
        {

            a2.add(j);
        }

        ArrayAdapter<Double> adapter2 = new ArrayAdapter<Double>(this, android.R.layout.simple_spinner_dropdown_item,a2);

        sp22.setAdapter(adapter2);






        ArrayList<Double> a3 = new ArrayList<Double>();
        for (Double k:arr3)
        {

            a3.add(k);
        }

        ArrayAdapter<Double> adapter3 = new ArrayAdapter<Double>(this, android.R.layout.simple_spinner_dropdown_item,a3);

        sp33.setAdapter(adapter3);









        ArrayList<String> a4 = new ArrayList<String>();
        for (String L:arr4)
        {

            a4.add(L);
        }

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,a4);

        sp44.setAdapter(adapter4);


        final Switch sw = findViewById(R.id.switch1);
        if (sw != null) {
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String msg = isChecked ? "Yes" : "No";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    sw.setText(msg);
                }
            });
        }









        ig = findViewById(R.id.imageView);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i.createChooser(i,"Pick an image"),GALLERY_REQUEST_CODE );





            }
        });
    }

    //--------Radio button Code-----------//



    public void addListenerOnButton() {

        radioSimGroup = (RadioGroup) findViewById(R.id.radiosex);
        btnDisplay = (Button) findViewById(R.id.button);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent.
                Intent ii = new Intent(v.getContext(), Second_activity.class);
                // get selected radio button from radioGroup
                int selectedId = radioSimGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioSimButton = (RadioButton) findViewById(selectedId);
                //data show by Toast
                Toast.makeText(getApplicationContext(), radioSimButton.getText(), Toast.LENGTH_SHORT).show();
                //data show by Toast
                //datapass
                String  rbdata = radioSimButton.getText().toString().trim();
                ii.putExtra("keyrdata", rbdata);
                //datapass
                startActivity(ii);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null);
        Uri imagedata = data.getData();
        ig.setImageURI(imagedata);
        Toast.makeText(MainActivity.this,"Image is imported", Toast.LENGTH_SHORT).show();

    }
}