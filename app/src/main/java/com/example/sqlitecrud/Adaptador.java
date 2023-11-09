package com.example.sqlitecrud;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    ArrayList<Contacto> lista;
    daoContacto dao;
    Contacto c;
    Activity a;
    int id=0;
    public Adaptador(Activity a,ArrayList<Contacto>lista, daoContacto dao){
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = this.id;
    }


    @Override
    public int getCount(){
        return lista.size();
    }
    @Override
    public Object getItem(int i){
        c=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c=lista.get(i);
        return c.getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

     @Override
    public View getView(int posicion, View view, ViewGroup viewGroup){
        View v = view;
        if (v == null){
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item, null);
        }
        c = lista.get(posicion);

        TextView nombre = v.findViewById(R.id.nombre);
        TextView apellido = v.findViewById(R.id.apellido);
        TextView email = v.findViewById(R.id.email);
        TextView telefono = v.findViewById(R.id.telefono);
        TextView ciudad = v.findViewById(R.id.ciudad);
        TextView editar = v.findViewById(R.id.editar);
        TextView borrar = v.findViewById(R.id.borrar);
        nombre.setText(c.GetNombre());
        apellido.setText(c.GetApellido());
        email.setText(c.GetEmail());
        telefono.setText(c.GetTelefono());
        ciudad.setText(c.GetCiudad());
        editar.setTag(posicion);
        borrar.setTag(posicion);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog dialog = new Dialog(a);
                dialog.setTitle("Editar Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText nombre = dialog.findViewById(R.id.nombre);
                final EditText apellido = dialog.findViewById(R.id.apellido);
                final EditText email = dialog.findViewById(R.id.email);
                final EditText telefono = dialog.findViewById(R.id.telefono);
                final EditText ciudad = dialog.findViewById(R.id.ciudad);
                Button guardar = dialog.findViewById(R.id.btn_agregar);
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                c = lista.get(pos);
                setId(c.getId());
                nombre.setText(c.GetNombre());
                apellido.setText(c.GetApellido());
                email.setText(c.GetEmail());
                telefono.setText(c.GetTelefono());
                ciudad.setText(c.GetCiudad());
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            c = new Contacto(getId(), nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    email.getText().toString(),
                                    telefono.getText().toString(),
                                    ciudad.getText().toString());
                            dao.Editar(c);
                            lista = dao.verTodo();
                            notifyDataSetChanged();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(a, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                c=lista.get(posicion);
                setId(c.getId());
                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("Estás seguro de eliminar?");
                del.setCancelable(false);
                del.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.Eliminar(getId());
                        lista = dao.verTodo();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }); del.show();
            }
    });

        return v;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }
}

