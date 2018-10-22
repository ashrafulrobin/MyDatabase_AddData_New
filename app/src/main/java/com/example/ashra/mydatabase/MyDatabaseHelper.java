package com.example.ashra.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ashra on 10/7/2018.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "Student.db";
    public static final String TABLE_NAME="student_details";
    public static final int VERSION_NUMBER = 3;

    public static final String ID = "_id";
    public static final String NAME = "Name";
    public static final String AGE = "Age";
    public static final String GENDER = "Gender";

    private Context context;
    public static final String CREATE_TABLE = " CREATE TABLE "+TABLE_NAME+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+AGE+" INTEGER,"+GENDER+" VARCHAR (15)); ";

    public static final String DROP_TABLE ="DROP TABLE IF EXISTS"+TABLE_NAME;

    public MyDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null, VERSION_NUMBER);

        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        try{

            Toast.makeText(context," onCreate is called ",Toast.LENGTH_LONG).show();

            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch ( Exception e){

            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{

            Toast.makeText(context,"onUpgrade is callled",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);


        }catch (Exception e){


            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();

        }

    }

public Long insertData(String name,String age,String gender){

      SQLiteDatabase sqLiteDatabase =this.getWritableDatabase() ;
    ContentValues contentValues = new ContentValues();
    contentValues.put(NAME,name);
    contentValues.put(AGE,age);
    contentValues.put(GENDER,gender);

  long rowID = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

  return rowID;
}

}

