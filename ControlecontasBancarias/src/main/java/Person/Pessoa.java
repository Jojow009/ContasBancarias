package Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private Long id;
    private Long cep;
    private int numero;
    private String complemento;
    private int situacao; // 1: Ativo, 0: Desabilitado
    private List<String> telefones;

    // Construtor
    public Pessoa(Long id, Long cep, int numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.situacao = 1; // Padrão: Ativo
        this.telefones = new ArrayList<>();
    }

    public Pessoa() {
    }

    // Métodos
    public void ler() {
        System.out.println("ID: " + id);
        System.out.println("CEP: " + cep);
        System.out.println("Número: " + numero);
        System.out.println("Complemento: " + complemento);
        System.out.println("Situação: " + (situacao == 1 ? "Ativo" : "Desabilitado"));
        System.out.println("Telefones: " + telefones);
    }

    // Gravar dados no arquivo
    public void gravar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pessoas.txt", true))) {
            writer.write("ID: " + id + "\n");
            writer.write("CEP: " + cep + "\n");
            writer.write("Número: " + numero + "\n");
            writer.write("Complemento: " + complemento + "\n");
            writer.write("Situação: " + (situacao == 1 ? "Ativo" : "Desabilitado") + "\n");
            writer.write("Telefones: " + telefones + "\n");
            writer.write("------------------------------------\n");
            System.out.println("Pessoa gravada com sucesso: " + id);
        } catch (IOException e) {
            System.out.println("Erro ao gravar pessoa no arquivo: " + e.getMessage());
        }
    }

    // Lista de Pessoas
    public static List<Pessoa> listaPessoas = new ArrayList<>();

    // Adicionar pessoa à lista
    public static void adicionarPessoa(Pessoa pessoa) {
        listaPessoas.add(pessoa);
        System.out.println("Pessoa adicionada: " + pessoa.getId());
    }

    // Remover pessoa da lista
    public static boolean removerPessoa(Long id) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getId().equals(id)) {
                listaPessoas.remove(pessoa);
                System.out.println("Pessoa removida: " + id);
                return true;
            }
        }
        System.out.println("Pessoa não encontrada para remoção: " + id);
        return false;
    }

    // Adicionar telefone à pessoa
    public void adicionarFone(String telefone) {
        this.telefones.add(telefone);
        System.out.println("Telefone adicionado: " + telefone);
    }

    // Remover telefone da pessoa
    public void removerFone(String telefone) {
        if (this.telefones.remove(telefone)) {
            System.out.println("Telefone removido: " + telefone);
        } else {
            System.out.println("Telefone não encontrado: " + telefone);
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }



}
