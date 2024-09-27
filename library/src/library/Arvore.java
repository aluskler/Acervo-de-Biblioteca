package library;

class No {
    Book livro;
    No esquerda, direita;

    public No(Book livro) {
        this.livro = livro;
        esquerda = direita = null;
    }
}

public class Arvore {
   private No raiz;

   public Arvore() {
      this.raiz = null;
   }

   public void inserir(Book livro) {
      this.raiz = this.inserirRecursivo(this.raiz, livro);
   }

   private No inserirRecursivo(No raiz, Book livro) {
      if (raiz == null) {
         return new No(livro);
      } else {
         if (livro.getTitle().compareToIgnoreCase(raiz.livro.getTitle()) < 0) {
            raiz.esquerda = this.inserirRecursivo(raiz.esquerda, livro);
         } else {
            raiz.direita = this.inserirRecursivo(raiz.direita, livro);
         }

         return raiz;
      }
   }

   public void buscarPorTitulo(String titulo) {
      System.out.println("Buscando livros com título: " + titulo);
      this.buscarTituloRecursivo(this.raiz, titulo);
   }

   private void buscarTituloRecursivo(No raiz, String titulo) {
      if (raiz != null) {
         this.buscarTituloRecursivo(raiz.esquerda, titulo);
         if (raiz.livro.getTitle().toLowerCase().contains(titulo.toLowerCase())) {
            System.out.println(raiz.livro);
         }
         this.buscarTituloRecursivo(raiz.direita, titulo);
      }
   }

   public void buscarPorAno(int ano) {
      System.out.println("Buscando livros do ano: " + ano);
      this.buscarAnoRecursivo(this.raiz, ano);
   }

   private void buscarAnoRecursivo(No raiz, int ano) {
      if (raiz != null) {
         this.buscarAnoRecursivo(raiz.esquerda, ano);
         if (raiz.livro.getReleaseYear() == ano) {
            System.out.println(raiz.livro);
         }
         this.buscarAnoRecursivo(raiz.direita, ano);
      }
   }

   public void buscarPorAutor(String autor) {
      System.out.println("Buscando livros do autor: " + autor);
      this.buscarAutorRecursivo(this.raiz, autor);
   }

   private void buscarAutorRecursivo(No raiz, String autor) {
      if (raiz != null) {
         this.buscarAutorRecursivo(raiz.esquerda, autor);
         if (raiz.livro.getAuthor().equalsIgnoreCase(autor)) {
            System.out.println(raiz.livro);
         }
         this.buscarAutorRecursivo(raiz.direita, autor);
      }
   }
}
