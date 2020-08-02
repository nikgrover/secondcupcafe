package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class menutwo extends AppCompatActivity {

    ListView listView;
    String mTitle[] ={"Mocha","Expresso","Black cofee","capacinno","turkish","laate"};
    int image[] ={R.drawable.cofone,R.drawable.coftwo,R.drawable.cofthree,R.drawable.cofee,R.drawable.cold};
    //img and title in array

    //past image in drawable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menutwo);

        listView = findViewById(R.id.listView);
        //creating adapter class

        MyAdapter adapter = new MyAdapter(this,mTitle,image);
        //set item click on list view

    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rTitle[];
        int rimg[];

        MyAdapter(Context c,String title[],int img[])
        {
            super(c,R.layout.cofeelist,R.id.textview1,title);
            this.context =c;
            this.rTitle =title;
            this.rimg = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.cofeelist,parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);


            //now set our resources on views

            images.setImageResource(rimg[position]);
            myTitle.setText(rTitle[position]);


            return row;
        }
    }
}