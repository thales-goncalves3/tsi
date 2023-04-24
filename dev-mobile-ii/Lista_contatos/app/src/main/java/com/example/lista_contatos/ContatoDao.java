package com.example.lista_contatos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContatoDao {
    @Query("SELECT * FROM contato")
    List<Contato> getAll();

    @Insert
    void insert(Contato... contatos);

    @Delete
    void delete(Contato contato);
}
