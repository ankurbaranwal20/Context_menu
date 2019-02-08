package com.example.ankurbaranwal.menues;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText ed1;
    ListView listView;
    ArrayList<String> a1;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.ed);
        b1= (Button)findViewById(R.id.but1);
        b2 = (Button)findViewById(R.id.bt);
        listView =(ListView)findViewById(R.id.list1);
        a1 = new ArrayList<>();
        ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a1);

        listView.setAdapter(ad);


        registerForContextMenu(b1);
        registerForContextMenu(b2);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.thirdmenu,menu);

        //getMenuInflater().inflate(R.menu.secondmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String name= ed1.getText().toString();

        switch (item.getItemId())
        {
            case R.id.add1:

                a1.add(ed1.getText().toString());
                ad.notifyDataSetChanged();
                Toast.makeText(this, "First option"+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.no:
                Toast.makeText(this, "second option"+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu, menu);

        menu.add(0,1,0,"Item3");
        menu.add(0,2,1,"Item4");

        SubMenu sm = menu.addSubMenu("sub menu");
        sm.add(0,3,2,"Submenu1");
        sm.add(0,4,1,"Submenu2");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item11:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item12:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
