/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO3;

import java.util.Scanner;

/**
 *
 * @author vinicius presoto
 */
public class AVL3 {

    //classe main, que tem a função de executar o programa, além disto, aparece no console as saidas (informações para o usuário)
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        AvlTree avl = new AvlTree();
        int x;
        do {
            System.out.println("Info: ");
            x = entrada.nextInt();
            if (x != 0) {
                avl.insertAVL(x);
            }
        } while (x != 0);
        avl.exibeAVL();

    }

}
