package com.example.myapp.lesson3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.myapp.R;
import com.example.myapp.lesson0.Dog;

import java.util.ArrayList;

/**
 * Created by konstantinaksenov on 29.09.14.
 */
public class ListActivity extends Activity {
    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    ArrayAdapter<String> adapter;
    ArrayList<Dog> dogs;
    MySimpleArrayAdapter mySimpleArrayAdapter;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvactivity);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        // находим список
        ListView lvMain = (ListView) findViewById(R.id.listView);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(ListActivity.this, names[position], Toast.LENGTH_SHORT).show();

            }
        });

        lvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //dogs.remove(position);
               // mySimpleArrayAdapter.notifyDataSetChanged();
                mySimpleArrayAdapter.remove(mySimpleArrayAdapter.getItem(position));
                return false;
            }
        });

 dogs = new ArrayList<Dog>();
        Dog dog = new Dog();
        dog.setName("Rex");
        dog.setLegCount(4);

        dogs.add(dog);

        Dog dog1 = new Dog();
        dog1.setName("Lessi");
        dog1.setLegCount(4);

        dogs.add(dog1);

        Dog dog2 = new Dog();
        dog2.setName("Rat");
        dog2.setLegCount(4);

        dogs.add(dog2);

        mySimpleArrayAdapter = new MySimpleArrayAdapter(this,dogs);

        lvMain.setAdapter(mySimpleArrayAdapter);

        // присваиваем адаптер списку
        //lvMain.setAdapter(adapter);

    }

   class MySimpleArrayAdapter extends ArrayAdapter<Dog> {
        private final Context context;

        public MySimpleArrayAdapter(Context context, ArrayList<Dog> dogs) {
            super(context, R.layout.dogs_item, dogs);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.dogs_item, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.textView);
            TextView textView1 = (TextView) rowView.findViewById(R.id.textView2);
            Dog dog = getItem(position);

            textView.setText(dog.getName());
            textView1.setText(String.valueOf(dog.getLegCount()));
            return rowView;
        }
    }


}
