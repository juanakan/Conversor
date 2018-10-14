package com.example.juanc.conversor_dam.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // creamos las variables de los tipos que necesitamos
    private Spinner sptumoneda, otramoneda;
    private EditText etcantidad;
    private TextView tvresultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //nuestras variables las enlazamos con los xml creados
        sptumoneda = (Spinner) findViewById(R.id.tumoneda);
        otramoneda = (Spinner) findViewById(R.id.nueva_moneda);
        etcantidad = (EditText) findViewById(R.id.insertar_cantidad);
        tvresultado = (TextView) findViewById(R.id.resultado);

        //creamos dos arrays con las monedas que vamos a necesitar
        String[] op_tumoneda = {"Euro", "Dollar", "Libra", "Peso", "Rupia", "Yen", "Dirham", "Franco", "Bitcoin", "Rublo", "Baht"};
        String[] op_otramoneda = {"Euro", "Dollar", "Libra", "Peso", "Rupia", "Yen", "Dirham", "Franco", "Bitcoin", "Rublo", "Baht"};

        //con el arrayadapter insertamos los arrays en las variables de tipo spiner que hemos creado
        ArrayAdapter<String> adapter_tumoneda = new ArrayAdapter<String>(this, R.layout.spiner_moneda, op_tumoneda);
        sptumoneda.setAdapter(adapter_tumoneda);

        ArrayAdapter<String> adapter_otramoneda = new ArrayAdapter<String>(this, R.layout.spiner_moneda, op_otramoneda);
        otramoneda.setAdapter(adapter_otramoneda);
    }

    //creo un metodo para que solo me devuelva en el calculo 4 decimales ya que me salian a veces un monton
    private String obtener_decimales(double valor){
        DecimalFormat format=new DecimalFormat();
        format.setMaximumFractionDigits(4);
        return format.format(valor);
    }
    // creo el metodo para cuando haga click en el boton calcular
    public void resultado_conver(View view) {
        String cantidad_String = etcantidad.getText().toString();

        //con este if y toast ponemos un mensaje cuando el usuario no mete ningun dato y asi nos quitamos un error
        if (cantidad_String.isEmpty()) {
            Toast toast = Toast.makeText(this, "Inserta una cantidad por favor", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            double cantidad_double = Double.parseDouble(cantidad_String);

            //creamos la variable string selec_tumon para recoger el nombre de la moneda elegida por el usuario
            String selec_tumon = sptumoneda.getSelectedItem().toString();


            //creamos la variable tumoned para asignar el valor de cada moneda de cada moneda
            double tumoned = 0;

            //este switch asigna un valor segun la moneda elegida
            switch (selec_tumon) {

                case "Euro":
                    tumoned = 1;
                    break;
                case "Dollar":
                    tumoned = 0.86440;
                    break;
                case "Libra":
                    tumoned = 1.14247;
                    break;
                case "Peso":
                    tumoned = 0.04533;
                    break;
                case "Rupia":
                    tumoned = 0.01166;
                    break;
                case "Yen":
                    tumoned = 0.00770;
                    break;
                case "Dirham":
                    tumoned = 0.09103;
                    break;
                case "Franco":
                    tumoned = 0.87425;
                    break;
                case "Bitcoin":
                    tumoned = 5402.69;
                    break;
                case "Rublo":
                    tumoned = 0.01299;
                    break;
                case "Baht":
                    tumoned = 0.02632;
                    break;

            }

            //creamos variable String selec_otramon para regoger la moneda elegida por el usuario
            String selec_otramon = otramoneda.getSelectedItem().toString();

            //creamos la variable otramoned para asignar el valor de la moneda elegida
            double otramoned = 0;

            ////este switch asigna un valor segun la moneda elegida
            switch (selec_otramon) {

                case "Euro":
                    otramoned = 1;
                    break;
                case "Dollar":
                    otramoned = 0.86440;
                    break;
                case "Libra":
                    otramoned = 1.14247;
                    break;
                case "Peso":
                    otramoned = 0.04533;
                    break;
                case "Rupia":
                    otramoned = 0.01166;
                    break;
                case "Yen":
                    otramoned = 0.00770;
                    break;
                case "Dirham":
                    otramoned = 0.09103;
                    break;
                case "Franco":
                    otramoned = 0.87425;
                    break;
                case "Bitcoin":
                    otramoned = 5402.69;
                    break;
                case "Rublo":
                    otramoned = 0.01299;
                    break;
                case "Baht":
                    otramoned = 0.02632;
                    break;

            }
            /* creamos la variable double resultado que calcula el valor de la moneda
            * primero lo convertimos en euros y con la division ya lo pasamos a la otra moneda*/
            double result = (cantidad_double * tumoned) / otramoned;

            /*creamos el string resultado que recoge el valor de result con el metodo obtener_decimales
            y el resultado lo convertimos a string */
            String resultado = String.valueOf(obtener_decimales(result)) + " " + selec_otramon + "s";

            //por ultimo le pasamos el resultado al textview que nos lo mostrara
            tvresultado.setText(resultado);
        }

    }
}