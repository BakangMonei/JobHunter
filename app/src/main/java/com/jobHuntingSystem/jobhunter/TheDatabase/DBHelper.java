package com.jobHuntingSystem.jobhunter.TheDatabase;

import java.util.*;


import android.content.*; // Context, ContentValues
import android.database.*; // Cursors
import android.database.sqlite.*; // SQLiteOpenHelper, SQLiteDatabase


/*
 * 1. Add new Student
 * 2. View Students
 * 3. Update student
 * 4. Delete Student*/

public class DBHelper extends SQLiteOpenHelper{

    com.jobHuntingSystem.jobhunter.TheDatabase.User U;
    // Creating a constructor for our database handler.
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Creating a constant variables for our database.
    private static final String DB_NAME = "usersDB"; // Variable is for our database name.
    private static final int DB_VERSION = 1; // Our database version
    private static final String TABLE_NAME = "Users"; // Variable is for our table name.

    private static final String EMAIL_COL = "email"; // Variable is for our email column.
    private static final String FIRSTNAME_COL = "firstName"; // Variable is for our firstName column
    private static final String LASTNAME_COL = "lastName"; // Variable is for our lastName column.
    private static final String GENDER_COL = "Gender"; // Variable is for our gender column.
    private static final String ADDRESS_COL = "PhysicalAddress"; // Variable is for our address column.
    private static final String COUNTRY_COL = "Country"; // Variable is for our Country column.
    private static final String IDPASSPORT_COL = "ID/Passport"; // Variable is for our ID/Passport numbers column.
    private static final String DOB_COL = "DateOfBirth"; // Variable is for our DOB column.
    private static final String PHONENUMBER_COL = "PhoneNumber"; // Variable is for our phoneNumber column.
    private static final String PASS_COL = "Password"; // Variable is for our phoneNumber column.
    private static final String REPASS_COL = "RePassWord"; // Variable is for our phoneNumber column.

    // Deleting Table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // The table + columns
    public void onCreate(SQLiteDatabase db){
        String query = "Create Table " + TABLE_NAME + "(" +
                EMAIL_COL + " TEXT," +
                FIRSTNAME_COL + " TEXT," +
                LASTNAME_COL + " TEXT," +
                GENDER_COL + " TEXT," +
                ADDRESS_COL + " TEXT," +
                COUNTRY_COL + " TEXT," +
                IDPASSPORT_COL + " TEXT," +
                DOB_COL + " TEXT," +
                PHONENUMBER_COL + " TEXT," +
                PASS_COL + " TEXT," +
                REPASS_COL + " TEXT)";
        db.execSQL(query); // At last we are calling a exec sql method to execute above sql query
    }

    // Method for adding new User to our sqlite database.
    public void addNewUser(String email, String firstName, String lastName, String Gender, String Address, String Country, String IDPassport, String DOB, String phoneNumber, String Password, String rePassword){
        SQLiteDatabase db = this.getWritableDatabase(); // This line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.
        ContentValues values = new ContentValues();// This line we are creating a variable for content values.

        // Below lines we are passing all values along with its key and value pair.
        values.put(EMAIL_COL, email);
        values.put(FIRSTNAME_COL, firstName);
        values.put(LASTNAME_COL, lastName);
        values.put(GENDER_COL, Gender);
        values.put(ADDRESS_COL, Address);
        values.put(COUNTRY_COL, Country);
        values.put(IDPASSPORT_COL, IDPassport);
        values.put(DOB_COL, DOB);
        values.put(PHONENUMBER_COL, phoneNumber);
        values.put(PASS_COL, Password);
        values.put(REPASS_COL, rePassword);

        // After adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null,values);
        // At last we are closing our database after adding database.
        db.close();
    }

    // Method for reading all Users
    public ArrayList<User> readUser(){
        SQLiteDatabase db = this.getReadableDatabase(); // On this line we are creating a database for reading our database.
        Cursor cursorUser = db.rawQuery("SELECT * FROM " + TABLE_NAME, null); // This line we are creating a cursor with query to read data from database.

        ArrayList<User> userArrayList= new ArrayList<>(); // This line we are creating a new array list.
        // Moving our cursor to first position.
        if (cursorUser.moveToFirst()){
            do{
                userArrayList.add(new User(
                        cursorUser.getString(0),
                        cursorUser.getString(1),
                        cursorUser.getString(2),
                        cursorUser.getString(3),
                        cursorUser.getString(4),
                        cursorUser.getString(5),
                        cursorUser.getString(6),
                        cursorUser.getString(7),
                        cursorUser.getString(8),
                        cursorUser.getString(9),
                        cursorUser.getString(10)));
            }
            while (cursorUser.moveToNext()); // moving our cursor to next
        }
        // Lastly closing our cursor and returning our array list.
        cursorUser.close();
        return userArrayList;
    }

    // Method to update User info
    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EMAIL_COL, user.email);
        values.put(FIRSTNAME_COL, user.firstName);
        values.put(LASTNAME_COL, user.lastName);
        values.put(GENDER_COL, user.Gender);
        values.put(ADDRESS_COL, user.Address);
        values.put(COUNTRY_COL, user.Country);
        values.put(IDPASSPORT_COL, user.IDPassport);
        values.put(DOB_COL, user.DOB);
        values.put(PHONENUMBER_COL, user.phoneNumber);
        values.put(PASS_COL, user.Password);
        values.put(REPASS_COL, user.rePassword);
        // Updating row
        db.update(TABLE_NAME, values, EMAIL_COL + " = ?", new String[] {String.valueOf(user.getEmail())});
        db.close();
    }
    // forgot password for sqlite
    public void changeForgottenPass(changePass change){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EMAIL_COL, change.emailChange);
        values.put(PASS_COL, change.password1);
        values.put(REPASS_COL, change.password2);
        db.update(TABLE_NAME, values, EMAIL_COL + " = ?", new String[] {String.valueOf(change.getEmailChange())});
        db.close();
    }

    // Method for deleting User
    public void deleteStudent(User delUser){
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete user by email
        db.delete(TABLE_NAME, EMAIL_COL + " = ?", new String[] {String.valueOf(delUser.getEmail())});
        db.close();
    }

    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from " + TABLE_NAME,null);
        return cursor;
    }


}