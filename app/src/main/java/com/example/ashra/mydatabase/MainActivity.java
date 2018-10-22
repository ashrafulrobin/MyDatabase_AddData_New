package com.example.ashra.mydatabase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ashra.mydatabase.R.id.addButtonId;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,ageEditText,genderEditText;
    private Button addButton ;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();


        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        ageEditText = (EditText) findViewById(R.id.ageEditTextId);
        genderEditText = (EditText) findViewById(R.id.genderEditTextId);
        addButton = (Button) findViewById(R.id.addButtonId);

        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();



        if(view.getId()==R.id.addButtonId){


                  long rowId  = myDatabaseHelper.insertData(name,age,gender);

                  if(rowId==-1)
                  {

                      Toast.makeText(getApplicationContext(),"unsuccessfull",Toast.LENGTH_LONG).show();
                  }else {


                      Toast.makeText(getApplicationContext(),"Row" +rowId+ "is successfully insert",Toast.LENGTH_LONG).show();
                  }


        }

    }
}
