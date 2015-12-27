/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "caminhofoto")
    private String caminhofoto;
    @Column(name = "email")
    private String email;
    //@Column(name = "genero")
    //private String email;
    @ManyToMany
    @JoinColumn(name = "idUsuario")
    private List<Livro> livros;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, String caminhofoto, String email) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.caminhofoto = caminhofoto;
        this.email = email;
    }

    public Usuario(int id, String nome, String login, String senha, String caminhofoto, String email) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.caminhofoto = caminhofoto;
        this.email = email;
    }

        
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCaminhofoto() {
        return caminhofoto;
    }

    public void setCaminhofoto(String caminhofoto) {
        this.caminhofoto = caminhofoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void adicionaLivro(Livro livro){
        this.livros.add(livro);
    }
    public void removeLivro(Livro livro){
        this.livros.remove(livro);
    }
    
}
