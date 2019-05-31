package facci.guillermoduran.practica4;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancia de RecyclerVeiw para agregar la funcionalidad
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Lista que representa el titulo de cada item
        ArrayList<String> tareas = new ArrayList<>();
        tareas.add("Personajes SFV");
        tareas.add("Ryu");
        tareas.add("Chun-li");
        tareas.add("Guile");
        tareas.add("Alex");
        tareas.add("Akuma");
        tareas.add("Ed");
        tareas.add("Falke");
        tareas.add("Ken");
        tareas.add("Birdie");
        tareas.add("Blanka");
        tareas.add("Ibuki");
        tareas.add("Cody");
        tareas.add("Dhalsim");
        tareas.add("Fang");
        tareas.add("G");
        tareas.add("Karin");
        tareas.add("Kolin");
        tareas.add("Menat");
        tareas.add("Nash");
        tareas.add("Urien");
        tareas.add("Vega");
        tareas.add("Zeku");

        ArrayList<String> estado = new ArrayList<>();
        estado.add("");
        estado.add("Hadouken");
        estado.add("Kikoken");
        estado.add("Sonic boom");
        estado.add("Flash chop");
        estado.add("Gohadouken");
        estado.add("Psycho upper");
        estado.add("Psycho Angrieff");
        estado.add("Shoryuken");
        estado.add("Dolphin dive");
        estado.add("Forward roll");
        estado.add("Raida");
        estado.add("Tornado sweep");
        estado.add("Yoga fire");
        estado.add("Sotoja");
        estado.add("G spin kick");
        estado.add("Tenko");
        estado.add("Vanity step");
        estado.add("Soul sphere");
        estado.add("Moonsault slash");
        estado.add("Chariot tackle");
        estado.add("Izuna drop");
        estado.add("Hozanto/Bushin tengen");

        int[] imagen ={
            R.drawable.transparent,
            R.drawable.ryu,
            R.drawable.chun,
            R.drawable.guile,
            R.drawable.alex,
            R.drawable.akuma,
            R.drawable.ed,
            R.drawable.falke,
            R.drawable.ken,
            R.drawable.birdie,
            R.drawable.blanka,
            R.drawable.ibuki,
            R.drawable.cody,
            R.drawable.dhalsim,
            R.drawable.fang,
            R.drawable.gaia,
            R.drawable.karin,
            R.drawable.kolin,
            R.drawable.menat,
            R.drawable.nash,
            R.drawable.urien,
            R.drawable.vega,
            R.drawable.zeku,
        };
        //Agregamos items a la lista
        /*for(int item = 0; item <= 10; item++){
            if(item == 0){
                tareas.add("Personajes SFV");
            }
                tareas.add("" + item);
        }*/


        //Asigna lista al adaptador creado
        TareasRecyclerViewAdapter adapter = new TareasRecyclerViewAdapter(this, tareas, estado, imagen);
        //Asigna adaptador al RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
