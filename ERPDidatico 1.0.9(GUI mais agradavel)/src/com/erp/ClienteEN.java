package com.erp;

public class ClienteEN {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;//adicionar cpf
    private int[] Cpf = new int[11];
    //111.111.111-11

    public ClienteEN(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
       
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    
public String desenha_cpf(int[] Cpf){
    return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d",
    Cpf[0], Cpf[1], Cpf[2],
    Cpf[3], Cpf[4], Cpf[5],
    Cpf[6], Cpf[7], Cpf[8],
    Cpf[9], Cpf[10]);
     
}
@Override
    public String toString() {
            
        System.out.println();
        System.out.println("Login efetuado com sucesso!");
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf= '"+ desenha_cpf(Cpf) + '\'' + "}";
    
}
}