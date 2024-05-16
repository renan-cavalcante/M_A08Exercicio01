package com.example.m_a08exercicio01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.m_a08exercicio01.model.Ingresso;
import com.example.m_a08exercicio01.model.IngressoVip;

public class MainActivity extends AppCompatActivity {
    private EditText etCodigo;
    private EditText etValor;
    private EditText etFuncao;
    private RadioButton rbNormal;
    private RadioButton rbVip;
    private Button btnComprar;
    private Ingresso ingresso;


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
        etCodigo = findViewById(R.id.etCodigo);
        etValor = findViewById(R.id.etValor);
        etFuncao = findViewById(R.id.etFuncao);
        rbNormal = findViewById(R.id.rbNormal);
        rbVip = findViewById(R.id.rbVip);
        btnComprar = findViewById(R.id.btnComprar);

        rbNormal.setChecked(true);
        rbNormal.setOnClickListener(op -> exibeIngNormal());
        rbVip.setOnClickListener(op -> exibeIngVip());

        btnComprar.setOnClickListener(op -> comprarIngresso());
    }

    private void comprarIngresso() {

        if(rbVip.isChecked()){
            ingresso = new IngressoVip();
            ((IngressoVip)ingresso).setFuncao(etFuncao.getText().toString());
        }
        if(rbNormal.isChecked()){
            ingresso = new Ingresso();
        }
        ingresso.setCodigo(etCodigo.getText().toString());
        ingresso.setValor(Float.parseFloat(etValor.getText().toString()));
        float valor = ingresso.valorFinal(0.1f);

        Bundle bundle = new Bundle();
        bundle.putString("codigo",ingresso.getCodigo());
        bundle.putFloat("preco", ingresso.getValor());
        bundle.putFloat("ValorFinal", valor);
        Log.i("Valor",String.valueOf(valor));
        bundle.putString("tipo", ingresso.getClass().getSimpleName());
        if(rbVip.isChecked()){
            bundle.putString("funcao",((IngressoVip)ingresso).getFuncao());
        }
        troca(bundle);

    }

    private void troca(Bundle bundle){
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }

    private void exibeIngVip() {
        etFuncao.setVisibility(View.VISIBLE);
    }

    private void exibeIngNormal() {
        etFuncao.setVisibility(View.INVISIBLE);
    }
}