package com.example.juan.nuevo.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sptumoneda, otramoneda;
    private EditText etcantidad;
    private TextView tvresultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sptumoneda = (Spinner) findViewById(R.id.tumoneda);
        otramoneda = (Spinner) findViewById(R.id.nueva_moneda);
        etcantidad = (EditText) findViewById(R.id.insertar_cantidad);
        tvresultado = (TextView) findViewById(R.id.resultado);

        String[] op_tumoneda = {"Euro", "Dollar", "Libra", "Peso", "Rupia", "Yen", "Dirham", "Franco", "Bitcoin", "Rublo", "Baht"};
        String[] op_otramoneda = {"Euro", "Dollar", "Libra", "Peso", "Rupia", "Yen", "Dirham", "Franco", "Bitcoin", "Rublo", "Baht"};

        ArrayAdapter<String> adapter_tumoneda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op_tumoneda);
        sptumoneda.setAdapter(adapter_tumoneda);

        ArrayAdapter<String> adapter_otramoneda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op_otramoneda);
        otramoneda.setAdapter(adapter_otramoneda);
    }

    public void resultado_conver(View view) {
        String cantidad_String = etcantidad.getText().toString();

        if (cantidad_String.isEmpty()) {
            Toast toast = Toast.makeText(this, "Inserta una cantidad por favor", Toast.LENGTH_LONG);
            toast.show();
        }else{
        double cantidad_double = Double.parseDouble(cantidad_String);
        String selec_tumon = sptumoneda.getSelectedItem().toString();

        double tumoned = 0;

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
        String selec_otramon = otramoneda.getSelectedItem().toString();
        double otramoned = 0;

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

            double result = (cantidad_double * tumoned) / otramoned;
            String resultado = String.valueOf(result) + " " + selec_otramon + "s";
            tvresultado.setText(resultado);
        }

    }
}