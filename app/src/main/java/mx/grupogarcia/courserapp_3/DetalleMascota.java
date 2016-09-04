package mx.grupogarcia.courserapp_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Luis Garcia on 03/09/2016.
 */
public class DetalleMascota extends AppCompatActivity {

    private ImageView imgvFoto;
    private TextView tvNombre;
    private TextView tvRaza;
    private TextView tvRaiting;
    private Toolbar miActionBar;
    private TextView tituloPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_mascotas);
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.name));
        String raza = parametros.getString(getResources().getString(R.string.race));
        String raiting = parametros.getString(getResources().getString(R.string.popularity));
        int foto = parametros.getInt(getResources().getString(R.string.image));

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tituloPantalla = (TextView) findViewById(R.id.tvTitulo);
        tituloPantalla.setText(getResources().getString(R.string.detail));

        imgvFoto = (ImageView) findViewById(R.id.imgvFoto) ;
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvRaza = (TextView) findViewById(R.id.tvRaza);
        tvRaiting = (TextView) findViewById(R.id.tvRating);

        imgvFoto.setImageResource(foto);
        tvNombre.setText(nombre);
        tvRaza.setText(raza);
        tvRaiting.setText(raiting);
    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleMascota.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }

    public void favoritos(View v) {

        /*
        Toast.makeText(this, "Regresar a Main", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MascotaFavorita.this, MainActivity.class);
        startActivity(intent);
        finish();
        */
    }

}