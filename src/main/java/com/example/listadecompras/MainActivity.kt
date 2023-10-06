package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val	produtosAdapter	=	ArrayAdapter<String>(this,	android.
        R.layout.simple_list_item_1)

        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)

        //botão de inserir o produto
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)

        //onde o usuario vai colocar o nome dos produtos
        val txt_produto = findViewById<EditText>(R.id.txt_produto)

        val checkBox = findViewById<CheckBox>(R.id.checkBox)

        list_view_produtos.adapter = produtosAdapter

        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view : View, position: Int, id: Long ->
            //buscando o item clicado
            val item = produtosAdapter.getItem(position)
            //removendo o item clicado na lista
            produtosAdapter.remove(item)

            true
        }

        btn_inserir.setOnClickListener{
            val produto = txt_produto.text.toString()
            //verificando se o usuário digitou algo
            if (produto.isNotEmpty()){
                //enviado o item para a lista
                produtosAdapter.add(produto)
                //limpando a caixa de texto
                txt_produto.text.clear()
            }else{
                txt_produto.error = "Preencha o campo"
            }
        }
    }

}