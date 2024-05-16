package com.example.m_a08exercicio01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SaidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvDados = findViewById(R.id.tvDados);
        Button btnvoltar = findViewById(R.id.btnVoltar);


        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        StringBuffer sb = new StringBuffer();
        sb.append(bundle.getString("tipo"));
        sb.append("\n");
        sb.append("Codigo: ");
        sb.append(bundle.getString("codigo"));
        sb.append("\n");
        sb.append("Valor:");
        sb.append(bundle.getFloat("preco"));
        sb.append("\n");

        if(bundle.getString("tipo").equals("IngressoVip")) {
            sb.append("função: ");
            sb.append(bundle.getString("funcao"));
            sb.append("\n");
        }
        sb.append("Valor Final: ");
        sb.append(bundle.getFloat("ValorFinal"));
        tvDados.setText(sb.toString());

        btnvoltar.setOnClickListener(op -> voltar());

    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}