package com.example.alessander.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int valorGasolina = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carregamento dos itens da minha SeekBar
        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        final TextView txtGasolina = (TextView)findViewById(R.id.txtValorGasolina);

        final Button btn = (Button)findViewById(R.id.btnCalcular);
        final TextView txtResultado = (TextView)findViewById(R.id.txtResultado);

        //Tamanho da SeekBar
        seekBar.setMax(1000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                valorGasolina = i;
                String texto = "R$ ";
                texto += formataValor(valorGasolina/100.0);
                txtGasolina.setText(texto);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtResultado.setText("Clique em Converter para saber o resultado");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorResultado = (valorGasolina * 0.7)/100.0;
                String texto = "Abasteça com Álcool se ele custar até: R$ ";
                texto += formataValor(valorResultado);

                txtResultado.setText(texto);
            }
        });

    }

    private String formataValor(double valor) {
        return String.format(Locale.FRANCE,"%.2f",valor);
    }
}
