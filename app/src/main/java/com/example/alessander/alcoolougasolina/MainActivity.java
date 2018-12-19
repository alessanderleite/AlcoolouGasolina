package com.example.alessander.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int valorGasolina = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView txtGasolina = (TextView) findViewById(R.id.txtValorGasolina);

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

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private String formataValor(double valor) {
        return String.format(Locale.FRANCE,"%.2f",valor);
    }
}
