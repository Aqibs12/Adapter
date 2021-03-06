package com.example.sqldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    public static final String COLUMN_ID = "ID";



    public DataBaseHelper(@Nullable Context context){
        super(context, "customer.db", null, 1);
    }

    //This is called the first time a database is accessed. There should be code in here to create a new Database.
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " +  CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL)";
        db.execSQL(createTableStatement);

    }

    //This is called if the database version number changes. It prevents previous user apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(newVersion>oldVersion)
            copyDatabase();


    }

    private void copyDatabase() {
    }

    public boolean addOne (CustomerModel customerModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
        cv.put(COLUMN_CUSTOMER_AGE, customerModel.getAge());
        cv.put(COLUMN_ACTIVE_CUSTOMER,customerModel.isActive());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);

        if (insert == -1){
            return false;
        }
        else {
            return true;
        }


    }

    public boolean deleteOne (CustomerModel customerModel){
        // Find Customer Model in the Database. if it find delete it and return true.
        //if it is not found return false.

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM" + CUSTOMER_TABLE + "WHERE" + COLUMN_ID + "=" + customerModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            return true;
        }else {

            return  false;
        }
    }


    public List<CustomerModel> getEveryone(){

        List<CustomerModel> returnList = new ArrayList<>();

        // get data from the database

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){

            // loop through the cursor (result set) and create new customer object. Put them into the result list.

            do {

                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                int customerAge = cursor.getInt(2);
                boolean customerActive = cursor.getInt(3) == 1 ? true: false;
                CustomerModel customerModel = new CustomerModel(customerID,customerName,customerAge,customerActive);
                returnList.add(customerModel);


            } while (cursor.moveToNext());

        }
        else {
        // Failure. Do not add anything to the list.
        }

        // Close both the cursor and the db when done.
        cursor.close();
        /*db.close();*/
        return returnList;
    }
}
