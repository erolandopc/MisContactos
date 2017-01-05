package net.edwinparedes.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Edwin Paredes","7396-7022","erolandopc@gmail.com"));
        contactos.add(new Contacto("Pedro Picapiedra", "2222-2222","pedro.picapiedra@gmail.com"));
        contactos.add(new Contacto("Vilma Traca", "3333-3333","vilma.traca@gmail.com"));
        contactos.add(new Contacto("Pablo Mármol","4444-4444","pablo.marmol@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));


        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });

    }
}
