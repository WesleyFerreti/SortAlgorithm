/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author Wesley Ferreti
 */
public abstract class Animal {

    private String nome;
    private int tamanho;
    private int peso;
    private int idade;

    
    public abstract void som();
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
    
    
    
    
}
