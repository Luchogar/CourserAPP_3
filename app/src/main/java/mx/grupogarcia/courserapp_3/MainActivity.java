package mx.grupogarcia.courserapp_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);
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

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota(R.drawable.chihuahua, "Luna", "Chihuahua "));
        mascotas.add(new Mascota(R.drawable.dogo, "Bethoven", "Dogo"));
        mascotas.add(new Mascota(R.drawable.husky, "taco", "Husky"));
        mascotas.add(new Mascota(R.drawable.pastor, "Flaca", "Pastor Aleman"));
        mascotas.add(new Mascota(R.drawable.pug, "Comotu", "Pug"));
        mascotas.add(new Mascota(R.drawable.terrier, "caramelo", "Terrier"));
        mascotas.add(new Mascota(R.drawable.bulldog, "Rex", "Bulldog"));

    }

    public void favoritos(View v){

        Toast.makeText(this, "Ir a Favoritos", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MascotaFavorita.class);
        startActivity(intent);
        //finish();
    }
}
