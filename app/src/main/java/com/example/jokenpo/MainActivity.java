package com.example.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
    }

    public void SelecinoarPedra(View view){
        VerificarGanhador("Pedra");
    }

    public void SelecinoarPapel(View view){
        VerificarGanhador("Papel");
    }
    public void SelecinoarTesoura(View view){
        VerificarGanhador("Tesoura");
    }

    private String gerarEscolhaAleatoria() {
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio =  new Random().nextInt(3);

        ImageView imageApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "Pedra":
                imageApp.setImageResource(R.drawable.pedra);
            break;
            case "Papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    private void VerificarGanhador( String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoria();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
            (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
            (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
            (escolhaApp == "Papel" && escolhaUsuario == "Pedra")
        ){ //APP GANHADOR
            textoResultado.setText("VOCE PERDEU");
        }
        else if (
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra")
        ) { //Usuario ganhador
            textoResultado.setText("VOCE GANAHOU");
        }
        else { // EMPATE
            textoResultado.setText("EMPATE");
        }

    }



}