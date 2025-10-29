package com.example.a05_exercicio1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    /*
     *@author: Felipe Pires de Araujo
     */

    /*
    Felipe Pires de Araujo
    1110482412004
    */
    private Spinner spQuantFaces;
    private RadioButton rbquant1;
    private RadioButton rbquant2;
    private RadioButton rbquant3;

    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        spQuantFaces = findViewById(R.id.spQuantFaces);
        rbquant1 = findViewById(R.id.rbquant1);
        rbquant2 = findViewById(R.id.rbquant2);
        rbquant3 = findViewById(R.id.rbquant3);
        Button btnRolar = findViewById(R.id.btnRolar);
        tvRes = findViewById(R.id.tvRes);

        preencheSpinner();
        btnRolar.setOnClickListener(op -> rolarDados());
    }

    private void rolarDados() {
        StringBuffer buffer = new StringBuffer();
        Integer qntFaces = (Integer) spQuantFaces.getSelectedItem();
        int min = 1;
        int numRepeticao;
        int i;

        if (rbquant1.isChecked()){
            numRepeticao = 1;
            }
        else if  (rbquant2.isChecked()){
                numRepeticao = 2;
            }
            else {
                    numRepeticao = 3;
            }

            for(i = 0; i < numRepeticao; i++) {
                int valor = min + (int) (Math.random() * qntFaces);
                buffer.append(" | " + valor + " | ");
            }



        tvRes.setText(buffer.toString());
    }

    private void preencheSpinner() {
            List<Integer> lista = new ArrayList<>();
            lista.add(4);
            lista.add(6);
            lista.add(8);
            lista.add(10);
            lista.add(12);
            lista.add(20);
            lista.add(100);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spQuantFaces.setAdapter(adapter);

    }
}