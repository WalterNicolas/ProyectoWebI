package com.tallerwebi.dominio;

public interface RepositorioUsuario {

    Usuario buscarUsuario(String email, String password);
    Usuario buscarPorId(Long id);
    void guardar(Usuario usuario);
    Usuario buscar(String email);
    void modificar(Usuario usuario);
    void updateData(Usuario usuario);
}

