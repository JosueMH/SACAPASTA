package es.marques.sacapasta;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Josue on 18/03/2016.
 */
public class CajeroAdapter extends BaseAdapter {

    private final List<Cajero> cajeros;
    public LayoutInflater inflater;
    Context context;

    public CajeroAdapter(Context context, List<Cajero> atms) {
        if (context == null || atms == null ) {
            throw new IllegalArgumentException();
        }
        this.cajeros = atms;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.cajeros.size();
    }

    @Override
    public Object getItem(int position) {
        return this.cajeros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cajero_simple_view = convertView;
        ViewHolder viewHolder;

        // Comprobamos si el view a rellenar existe o hay que crearlo.
        if(cajero_simple_view == null) {
            //Inflamos el layout
            cajero_simple_view = this.inflater.inflate(R.layout.layout_vista_simple_cajero,parent,false);
            //Creamos el viewHolder, accedemos a los elementos del view que acabmos de inflar y los guardamos en el ViewHolder.
            viewHolder = new ViewHolder();
            viewHolder.cajeroName = (TextView) cajero_simple_view.findViewById(R.id.TextView_nombreCajero);
            viewHolder.cajeroDirection = (TextView) cajero_simple_view.findViewById(R.id.TextView_calleCajero);
            viewHolder.cajeroTipo = (ImageView) cajero_simple_view.findViewById(R.id.imageView_tipoCajero);
            // Asignamos el viewHolder al layout que inflamos en primer lugar.
            cajero_simple_view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) cajero_simple_view.getTag();
        }

        // Rellenamos el View con los datos.
        Cajero cajero = this.cajeros.get(position);
        viewHolder.cajeroName.setText(cajero.getNombre());
        viewHolder.cajeroDirection.setText(cajero.getDireccion());
        //Aqui dependiendo del tipo del cajero, mostramos uno u otro icono:
        if (cajero.getTipo().equals( context.getResources().getString(R.string.tipo_cajero_oficina))){
            viewHolder.cajeroTipo.setImageResource(R.mipmap.ic_cajero_oficina);
        }
        else viewHolder.cajeroTipo.setImageResource(R.mipmap.ic_cajero_automatico);

        return cajero_simple_view;
    }

    // Con esta clase podemos almacenar las variables para acceder a los views del layout sin tener que buscarlos con findVewByID().
    static class ViewHolder {
        public TextView cajeroName;
        public TextView cajeroDirection;
        public ImageView cajeroTipo;
    }
}
