/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO3;

/**
 *
 * @author vinicius presoto
 */
public class AvlNode {

    //declaração das variáveis necessárias para criar os campos necessários do node dir, info e esquerda
    AvlNode esq;
    int info;
    AvlNode dir;
    int altura;

// construtor - através dele é possível inserir as informações necessárias que compôe um nó (dir, info, esq).
    AvlNode(int info) {
        this(null, info, null);
    }

    // construtor - através dele é possível inserir as informações necessárias que compôe um nó (dir, info, esq).
    AvlNode(AvlNode esquerda, int info, AvlNode direita) {
        this.esq = esquerda;
        this.info = info;
        this.dir = direita;
        this.altura = 0;
    }

}
