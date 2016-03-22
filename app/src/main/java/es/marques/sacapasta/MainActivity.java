package es.marques.sacapasta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cajero> lista_cajeros= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvItems = (ListView) findViewById(R.id.listView_cajeros);

        String [] cajeros = getResources().getStringArray(R.array.cajeros_nombre);
        String [] calles = getResources().getStringArray(R.array.cajeros_calle);
        String [] tipos = getResources().getStringArray(R.array.cajeros_tipo);

        lista_cajeros = createLista_cajeros(cajeros, calles, tipos);

        CajeroAdapter adapter = new CajeroAdapter(this,
                lista_cajeros);
        lvItems.setAdapter(adapter);
    }

    public ArrayList<Cajero> createLista_cajeros(String[] cajeros, String[] calles, String[] tipos){

        if(cajeros.length != calles.length || cajeros.length != tipos.length){
            throw new IllegalStateException();
        }
        ArrayList<Cajero> lista = new ArrayList<Cajero>();
        for (int i=0; i<cajeros.length; i++){
            Cajero c = new Cajero(cajeros[i], calles[i], tipos[i]);
            lista.add(c);
        }

        return lista;
    }
}


