package com.example.lista_contatos;

//cuidado com o package de vocês. Não apaguem ele.
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class MeuAdaptador extends ArrayAdapter<Contato> {

    LayoutInflater inflater;
    int resourceId;

    public MeuAdaptador(@NonNull Context context, int resource, @NonNull List<Contato> objects) {
        super(context, resource, objects);
        resourceId = resource;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(resourceId, parent, false);
        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtFone = convertView.findViewById(R.id.txtFone);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);

        Contato contato = getItem(position);
        txtNome.setText(contato.nome);
        txtFone.setText(contato.telefone);
        txtEmail.setText(contato.email);

        return convertView;
    }
}