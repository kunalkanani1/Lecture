package com.kunal.lecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

/*
button array
tictactoe
numberpuzzle
linearlayout
relative
emi
bmi

listview/gridview/spinner/gallery/autocpmpletetextview-arrayadapter
checkbox/radiobutton
 */
public class MainActivity extends AppCompatActivity {

    String[] city_arr={"surat","baroda","vapi","valsad","mumbai","pune","goa"};
    int[] contact_arr={122,345,234,543,765,890,778};
    int[] img={R.drawable.apple,R.drawable.bg,R.drawable.bg2,R.drawable.logo,R.drawable.apple,R.drawable.bg,R.drawable.bg2};

    ListView listView;//vertical
    GridView gridView;//column
    Spinner spinner;//dropdown
    Gallery gallery;//horizpnal
    AutoCompleteTextView autoCompleteTextView;//suggestion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.listview);
        MyAdapter m=new MyAdapter(this,city_arr,contact_arr,img);
        gridView.setAdapter(m);


    }
}