package mx.grupogarcia.courserapp_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis Garcia on 03/09/2016.
 */
public class MascotaFavorita extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private TextView tituloPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tituloPantalla = (TextView) findViewById(R.id.tvTitulo);
        tituloPantalla.setText(getResources().getString(R.string.popularity));

        listaMascotas = (RecyclerView) findViewById(R.id.mascotasfavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_petagram, menu);
        return true;
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota(R.drawable.chihuahua, "Luna", "Chihuahua "));
        mascotas.add(new Mascota(R.drawable.dogo, "Bethoven", "Dogo"));
        mascotas.add(new Mascota(R.drawable.husky, "taco", "Husky"));
        mascotas.add(new Mascota(R.drawable.pastor, "Flaca", "Pastor Aleman"));
        mascotas.add(new Mascota(R.drawable.pug, "Comotu", "Pug"));
        mascotas.add(new Mascota(R.drawable.terrier, "caramelo", "Terrier"));
        mascotas.add(new Mascota(R.drawable.bulldog, "Rex", "Bulldog"));

    }

    public void favoritos(View v) {

        /*
        Toast.makeText(this, "Regresar a Main", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MascotaFavorita.this, MainActivity.class);
        startActivity(intent);
        finish();
        */
    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MascotaFavorita.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}