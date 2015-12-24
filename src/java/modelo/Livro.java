/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lucas
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id")
    private int id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "ano")
    private int ano;
    @Column(name = "volume")
    private int volume;
    @Column(name = "paginas")
    private int paginas;
    @Column(name = "edicao", length = 45)
    private String edicao;
    @Column(name = "caminhofoto")
    private String caminhofoto;
    @OneToOne
    @JoinColumn(name = "idAutor")
    private Autor autor;
    @OneToOne
    @JoinColumn(name = "idEditora")
    private Editora editora;
    @OneToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    @OneToOne
    @JoinColumn(name = "idStatus")
    private Status status;
    @OneToOne
    @JoinColumn(name = "idStatusLeitura")
    private StatusLeitura statusleitura;

    public Livro() {
    }

    public Livro(int id, String titulo, int ano, int volume, int paginas, String edicao, String caminhofoto, Autor autor, Editora editora, Categoria categoria, Status status, StatusLeitura statusleitura) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.volume = volume;
        this.paginas = paginas;
        this.edicao = edicao;
        this.caminhofoto = caminhofoto;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
        this.status = status;
        this.statusleitura = statusleitura;
    }

    public Livro(String titulo, int ano, int volume, int paginas, String edicao, String caminhofoto, Autor autor, Editora editora, Categoria categoria, Status status, StatusLeitura statusleitura) {
        this.titulo = titulo;
        this.ano = ano;
        this.volume = volume;
        this.paginas = paginas;
        this.edicao = edicao;
        this.caminhofoto = caminhofoto;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
        this.status = status;
        this.statusleitura = statusleitura;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusLeitura getStatusleitura() {
        return statusleitura;
    }

    public void setStatusleitura(StatusLeitura statusleitura) {
        this.statusleitura = statusleitura;
    }
    
     
    
    
}