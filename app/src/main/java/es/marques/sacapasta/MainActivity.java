package es.marques.sacapasta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvItems = (ListView) findViewById(R.id.listView_cajeros);
        String [] cajeros = getResources().getStringArray(R.array.cajeros_nombre);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cajeros);
        lvItems.setAdapter(adapter);
    }
}
