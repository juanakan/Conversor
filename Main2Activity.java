package com.example.juanc.conversor_dam.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //creamos el bundle que para recoger los datos de la primera actividad
        Bundle datos=getIntent().getExtras();

        //creamos dos arrays donde recogemos los datos de los arrais de la primera actividad
        String[] paises=datos.getStringArray("paismoneda");
        double[] valores=datos.getDoubleArray("valormoneda");

        //creamos el listview
        ListView lista =(ListView) findViewById(R.id.lv1);

        //creamos un arraylist para incorporar los datos de los arrays
        ArrayList<String> monedavalor=new ArrayList<>();

        //introducimos los valores al arraylist
        monedavalor.add(paises[0]+" = "+valores[0]);
        monedavalor.add(paises[1]+" = "+valores[1]);
        monedavalor.add(paises[2]+" = "+valores[2]);
        monedavalor.add(paises[3]+" = "+valores[3]);
        monedavalor.add(paises[4]+" = "+valores[4]);
        monedavalor.add(paises[5]+" = "+valores[5]);
        monedavalor.add(paises[6]+" = "+valores[6]);
        monedavalor.add(paises[7]+" = "+valores[7]);
        monedavalor.add(paises[8]+" = "+valores[8]);
        monedavalor.add(paises[9]+" = "+valores[9]);

        //creamos el arrayadapter para recoger los datos del arraylist
        ArrayAdapter<String> adaptermoneda=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,monedavalor);

        //introducimos los valores recogidos con el arrayadapter y los metemos en el listview
        lista.setAdapter(adaptermoneda);


    }
    public void Anterior (View view){
        Intent Anterior =new Intent(this,MainActivity.class);
        startActivity(Anterior);
    }
}
