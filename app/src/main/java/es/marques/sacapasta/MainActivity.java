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
                R.layout.layout_vista_simple_cajero,R.id.TextView_nombreCajero,cajeros);
        lvItems.setAdapter(adapter);
    }
}
