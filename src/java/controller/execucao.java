/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author stock
 * 
 */
@WebServlet(name = "execucao", urlPatterns = {"/execucao"})
public class execucao extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
    


        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String exe = request.getParameter("exe");

            if (exe.equals("CADASTRAR")) {
                try {
                    Cliente cli = InstanciarCliente(request);
                    ClienteDAO cdao = new ClienteDAO();
                    cdao.cadastrar(cli);
                    request.setAttribute("msg", "Cadastrado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }

            } else if (exe.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente cli = new Cliente();
                ClienteDAO adao = new ClienteDAO();
                cli.setId(id);
                try {
                    adao.deletar(cli);
                    request.setAttribute("msg", "Deletado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (exe.equals("ATUALIZAR")) {
                try {
                    Cliente cli = InstanciarCliente(request);
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    cli.setId(id);

                    ClienteDAO cdao = new ClienteDAO();
                    cdao.atualizar(cli);
                    request.setAttribute("msg", "Atualizado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            } else if (exe.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente cli = new Cliente();
                ClienteDAO cdao = new ClienteDAO();
                cli.setId(id);

                try {
                    Cliente cliconsultado = cdao.consultarById(cli);
                    request.setAttribute("cliente", cliconsultado);
                    request.getRequestDispatcher("consultarId.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (exe.equals("CONSULTAR TODOS")) {
                ClienteDAO cdao = new ClienteDAO();
                try {
                    List<Cliente> clientesConsultados = cdao.consultarTodos();
                    request.setAttribute("clientesConsultados", clientesConsultados);
                    request.getRequestDispatcher("consultarTodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
        }
    }

    private Cliente InstanciarCliente(HttpServletRequest request) {
        String nome = request.getParameter("txtnome");
        int idade = Integer.parseInt(request.getParameter("txtidade"));
        String email = request.getParameter("txtemail");
        String senha = request.getParameter("txtsenha");
        String telefone = request.getParameter("txttelefone");
        String endereco = request.getParameter("txtendereco");
        String cidade = request.getParameter("txtcidade");
        String estado = request.getParameter("txtestado");
        String cep = request.getParameter("txtcep");
        String dataNascimento = request.getParameter("txtdataNascimento");

        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setIdade(idade);
        cli.setEmail(email);
        cli.setSenha(senha);
        cli.setTelefone(telefone);
        cli.setEndereco(endereco);
        cli.setCidade(cidade);
        cli.setEstado(estado);
        cli.setCep(cep);
        cli.setDataNascimento(dataNascimento);

        return cli;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
