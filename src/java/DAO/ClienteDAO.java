/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.InovagasConexao;

/**
 *
 * @author stock
 */
public class ClienteDAO {
    public void cadastrar(Cliente cli) throws ClassNotFoundException, SQLException {
        Connection con = InovagasConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into cliente (nome, idade, email, senha, telefone, endereco, cidade, estado, cep, dataNascimento) values (?,?,?,?,?,?,?,?,?,?)");
        comando.setString(1, cli.getNome());
        comando.setInt(2, cli.getIdade());
        comando.setString(3, cli.getEmail());
        comando.setString(4, cli.getSenha());
        comando.setString(5, cli.getTelefone());
        comando.setString(6, cli.getEndereco());
        comando.setString(7, cli.getCidade());
        comando.setString(8, cli.getEstado());
        comando.setString(9, cli.getCep());
        comando.setString(10, cli.getDataNascimento());
        comando.execute();
        con.close();
    }

    public void deletar(Cliente cli) throws ClassNotFoundException, SQLException {
        Connection con = InovagasConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from cliente where id = ?");
        comando.setInt(1, cli.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Cliente cli) throws ClassNotFoundException, SQLException {
        Connection con = InovagasConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update cliente set nome = ?, idade = ?, email = ?, senha = ?, telefone = ?, endereco = ?, cidade = ?, estado = ?, cep = ?, dataNascimento = ? where id = ?");
        comando.setString(1, cli.getNome());
        comando.setInt(2, cli.getIdade());
        comando.setString(3, cli.getEmail());
        comando.setString(4, cli.getSenha());
        comando.setString(5, cli.getTelefone());
        comando.setString(6, cli.getEndereco());
        comando.setString(7, cli.getCidade());
        comando.setString(8, cli.getEstado());
        comando.setString(9, cli.getCep());
        comando.setString(10, cli.getDataNascimento());
        comando.setInt(11, cli.getId());
        comando.execute();
        con.close();
    }

    //public void atualizar (Prod prod) throws ClassNotFound
    public Cliente consultarById(Cliente cli) throws ClassNotFoundException, SQLException {
        Connection con = InovagasConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from cliente where id=?");
        comando.setInt(1, cli.getId());
        ResultSet rs = comando.executeQuery();

        Cliente c = new Cliente();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setIdade(rs.getInt("idade"));
            c.setEmail(rs.getString("email"));
            c.setSenha(rs.getString("senha"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setCidade(rs.getString("cidade"));
            c.setEstado(rs.getString("estado"));
            c.setCep(rs.getString("cep"));
            c.setDataNascimento(rs.getString("dataNascimento"));
        }

        con.close();
        return c;
    }

    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {

        Connection con = InovagasConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from cliente");
        ResultSet rs = comando.executeQuery();
        List<Cliente> lcli = new ArrayList();
        while (rs.next()) {
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNome(rs.getString("nome"));
            cli.setIdade(rs.getInt("idade"));
            cli.setEmail(rs.getString("email"));
            cli.setSenha(rs.getString("senha"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setEndereco(rs.getString("endereco"));
            cli.setCidade(rs.getString("cidade"));
            cli.setEstado(rs.getString("estado"));
            cli.setCep(rs.getString("cep"));
            cli.setDataNascimento(rs.getString("dataNascimento"));
            lcli.add(cli);
        }
        return lcli;
    }
}
