package com.example.llamandoawalter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewStatus;
    private ImageView imageViewWalter;
    private ImageButton imageButtonCall;
    private boolean isCalling = false;
    private boolean callEnded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = findViewById(R.id.textViewStatus);
        imageViewWalter = findViewById(R.id.imageViewWalter);
        imageButtonCall = findViewById(R.id.imageButtonCall);

        imageButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCall();
            }
        });
    }

    private void handleCall() {
        if (!isCalling && !callEnded) {
            // Primer estado: Llamando a Walter White
            textViewStatus.setText("Llamando a Walter White...");
            imageViewWalter.setImageResource(R.drawable.walterwhite2); // Imagen de Walter con sombrero (al llamar)
            imageButtonCall.setImageResource(R.drawable.colgar); // Cambiar botón a colgar
            isCalling = true;
        } else if (isCalling) {
            // Segundo estado: Llamada terminada
            textViewStatus.setText("Llamada terminada");
            imageViewWalter.setImageResource(R.drawable.walterwhite); // Imagen de Walter sin sombrero (normal)
            imageButtonCall.setImageResource(R.drawable.llamar); // Cambiar botón a llamar
            isCalling = false;
            callEnded = true;
        } else if (callEnded) {
            // Volver al estado inicial
            textViewStatus.setText("Pulsa para llamar a Walter White");
            imageViewWalter.setImageResource(R.drawable.walterwhite);
            imageButtonCall.setImageResource(R.drawable.llamar);
            callEnded = false;
        }
    }
}
