package br.edu.alfaumuarama.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.alfaumuarama.hackathon.datasources.DownloadImagem;

public class DetalhesActivity extends AppCompatActivity {

    TextView nome, disponibilidade, preco;
    ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        nome = findViewById(R.id.nome);
        disponibilidade = findViewById(R.id.disponibilidade);
        preco = findViewById(R.id.preco);
        imagem = findViewById(R.id.imagem);

        //capturando o caminho de tela utilizado para abrir esta tela
        Intent dadosRecebidos = getIntent();
        if (dadosRecebidos != null) {
            //capturando os dados recebidos no caminho de tela
            Bundle params = dadosRecebidos.getExtras();
            if (params != null) {
                //adicionando o nome do pokemon no texto da tela
                nome.setText(params.getString("nome"));
                disponibilidade.setText(params.getString("disponibilidade"));
                preco.setText(params.getString("preco"));

                //carregando a imagem da web no objeto imagem da tela
                new DownloadImagem(imagem).execute(params.getString("imagem"));
            }
        }
    }
}