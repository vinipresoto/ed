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
public class AvlTree {

    private AvlNode raiz;

    //construtor - inicia com o elemento raiz da arvore.
    public AvlTree() {
        this.raiz = null;
    }

    // classe criada para verificar a altura máxima da arvore AVL
    private static int maxAVL(int a, int b) {
        if (a > b) {
            return (a);
        } else {
            return (b);
        }
    }

    // classe criada para verificar a altura da arvore AVL
    private static int alturaAVL(AvlNode t) {
        if (t == null) {
            return (-1);
        } else {
            return (t.altura);
        }

    }

    // classe criada para fazer uma rotação simples à esquerda.
    private static AvlNode rotacaoEsquerdaAVL(AvlNode nodoOut) {
        AvlNode nodoIn = nodoOut.esq;
        int a, b;
        nodoOut.esq = nodoIn.dir;
        nodoIn.dir = nodoOut;
        a = AvlTree.alturaAVL(nodoOut.esq);
        b = AvlTree.alturaAVL(nodoOut.dir);
        nodoOut.altura = AvlTree.maxAVL(a, b) + 1;
        a = AvlTree.alturaAVL(nodoIn.esq);
        b = nodoOut.altura;
        nodoIn.altura = AvlTree.maxAVL(a, b) + 1;
        return (nodoIn);

    }

    // classe criada para fazer uma rotação simples à direita.
    private static AvlNode rotacaoDireitaAVL(AvlNode nodoOut) {
        AvlNode nodoIn = nodoOut.dir;
        int a, b;
        nodoOut.dir = nodoIn.esq;
        nodoIn.esq = nodoOut;
        a = AvlTree.alturaAVL(nodoOut.esq);
        b = AvlTree.alturaAVL(nodoOut.dir);
        nodoOut.altura = AvlTree.maxAVL(a, b) + 1;
        a = AvlTree.alturaAVL(nodoIn.dir);
        b = nodoOut.altura;
        nodoIn.altura = AvlTree.maxAVL(a, b) + 1;
        return (nodoIn);
    }

    // classe criada para fazer uma rotação dupla à esquerda.
    private static AvlNode rotacaoDuplaEsquerdaAVL(AvlNode nodo) {
        nodo.esq = AvlTree.rotacaoEsquerdaAVL(nodo.esq);
        return (AvlTree.rotacaoEsquerdaAVL(nodo));
    }

    // classe criada para fazer uma rotação dupla à direita.
    private static AvlNode rotacaoDuplaDireitaAVL(AvlNode nodo) {
        nodo.dir = AvlTree.rotacaoEsquerdaAVL(nodo.dir);
        return (AvlTree.rotacaoDireitaAVL(nodo));
    }

    // classe criada para verificar se a arvore está vazia ou não. (boolen = verdadeiro ou falso).
    public boolean vaziaAVL() {
        return this.raiz == null;
    }

    // classe criada para fazer a inserção de um elemento na arvore.
    public void insertAVL(int info) {
        this.raiz = insertAVL(info, this.raiz);
    }

    // classe criada para fazer a inserção de um node na arvore.
    private AvlNode insertAVL(int x, AvlNode avl) {
        int a, b;
        if (avl == null) {
            avl = new AvlNode(null, x, null);
        } else {
            if (x > avl.info) {
                avl.dir = insertAVL(x, avl.dir);
                a = AvlTree.alturaAVL(avl.dir);
                b = AvlTree.alturaAVL(avl.esq);
                if (a - b == 2) {
                    if (x > avl.dir.info) {
                        avl = AvlTree.rotacaoDireitaAVL(avl);
                    } else {
                        avl = AvlTree.rotacaoDuplaDireitaAVL(avl);
                    }
                }
            } else {
                if (x < avl.info) {
                    avl.esq = insertAVL(x, avl.esq);
                    a = AvlTree.alturaAVL(avl.esq);
                    b = AvlTree.alturaAVL(avl.dir);
                    if (a - b == 2) {
                        if (x < avl.esq.info) {
                            avl = AvlTree.rotacaoEsquerdaAVL(avl);
                        } else {
                            avl = AvlTree.rotacaoDuplaEsquerdaAVL(avl);
                        }
                    }
                }
            }
        }
        a = AvlTree.alturaAVL(avl.esq);
        b = AvlTree.alturaAVL(avl.dir);
        avl.altura = AvlTree.maxAVL(a, b) + 1;
        return (avl);
    }

    // classe criada para que seja exibida a arvore avl existente.
    public void exibeAVL() {
        if (vaziaAVL()) {
            System.out.println("Status: AVL Vazia");
        } else {
            exibeAVL(this.raiz, 1);
        }
    }

    private void exibeAVL(AvlNode avl, int t) {
        if (avl != null) {
            exibeAVL(avl.dir, t + 1);
            for (int i = 0; i < t; i++) {
                System.out.println(" ");
            }
            System.out.println("%d \n, avl.info");
            exibeAVL(avl.esq, t + 1);

        }
    }
    
    
}
