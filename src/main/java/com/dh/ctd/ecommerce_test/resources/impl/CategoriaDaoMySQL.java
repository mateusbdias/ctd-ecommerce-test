package com.dh.ctd.ecommerce_test.resources.impl;

import com.dh.ctd.ecommerce_test.model.Categoria;
import com.dh.ctd.ecommerce_test.resources.IDao;
import com.dh.ctd.ecommerce_test.resources.config.ConfigJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDaoMySQL implements IDao<Categoria> {

    private ConfigJDBC configJDBC;

    public CategoriaDaoMySQL() {
        this.configJDBC = new ConfigJDBC();
    }


    @Override
    public Categoria salvar(Categoria categoria) {
        Connection conn = configJDBC.connectToDB();
        PreparedStatement ps = null;

        String query = String.format("INSERT INTO categorias " +
                "(nome) VALUES ('%s');",
                categoria.getNome());

        try {
            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                categoria.setId(keys.getInt(1));
            }
            ps.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public Optional<Categoria> buscar(Integer id) {
        Connection conn = configJDBC.connectToDB();
        Statement st = null;

        String query = String.format(
                "SELECT id, nome FROM categorias WHERE id = '%s';");
        Categoria categoria = null;

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                categoria = criarObjetoCategoria(rs);
            }
            st.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria != null ? Optional.of(categoria) : Optional.empty();
    }

    @Override
    public List<Categoria> buscarTodos() {
        Connection conn = configJDBC.connectToDB();
        PreparedStatement ps = null;

        String query = "SELECT * FROM categorias;";
        List<Categoria> categorias = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                categorias.add(criarObjetoCategoria(rs));
            }
            ps.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    @Override
    public void excluir(Integer id) {
        Connection conn = configJDBC.connectToDB();
        Statement st = null;
        String query = String.format("DELETE FROM categorias WHERE " +
                "id = '%s';", id);
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        Connection conn = configJDBC.connectToDB();
        String query = String.format(
                "UPDATE categorias SET nome = '%s' WHERE id = '%s';",
                categoria.getNome(),
                categoria.getId());
        execute(conn, query);
        return categoria;
    }

    private Categoria criarObjetoCategoria(ResultSet rs) throws SQLException {
        return new Categoria(
                rs.getInt("id"),
                rs.getString("nome"));
    }

    private void execute(Connection conn, String query) {
        try {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
