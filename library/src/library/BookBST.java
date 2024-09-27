package library;

class TreeNode {
    Book book;
    TreeNode left, right;

    public TreeNode(Book book) {
        this.book = book;
        left = right = null;
    }
}
public class BookBST {
    private TreeNode root;

    public BookBST() {
        this.root = null;
    }

    // Inserir livro na árvore baseada no autor
    public void insert(Book book) {
        this.root = insertRec(root, book);
    }

    private TreeNode insertRec(TreeNode root, Book book) {
        if (root == null) {
            root = new TreeNode(book);
            return root;
        }

        if (book.getAuthor().compareToIgnoreCase(root.book.getAuthor()) < 0) {
            root.left = insertRec(root.left, book);
        } else if (book.getAuthor().compareToIgnoreCase(root.book.getAuthor()) > 0) {
            root.right = insertRec(root.right, book);
        }

        return root;
    }

    // Função para remover um livro
    public void remove(String author) {
        this.root = removeRec(root, author);
    }

    private TreeNode removeRec(TreeNode root, String author) {
        if (root == null) {
            return root;
        }

        // Percorrer a árvore até encontrar o nó a ser removido
        if (author.compareToIgnoreCase(root.book.getAuthor()) < 0) {
            root.left = removeRec(root.left, author);
        } else if (author.compareToIgnoreCase(root.book.getAuthor()) > 0) {
            root.right = removeRec(root.right, author);
        } else {
            // Caso 1: O nó é uma folha (sem filhos)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Caso 2: O nó tem apenas um filho
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Caso 3: O nó tem dois filhos
            // Encontrar o sucessor in-order (menor valor da subárvore da direita)
            root.book = findMin(root.right).book;
            root.right = removeRec(root.right, root.book.getAuthor());
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Método para buscar livros por autor
    public void searchByAuthor(String author) {
        searchByAuthorRec(root, author);
    }

    private void searchByAuthorRec(TreeNode root, String author) {
        if (root != null) {
            searchByAuthorRec(root.left, author);
            if (root.book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(root.book);
            }
            searchByAuthorRec(root.right, author);
        }
    }

    // Método para recomendar livros por tema (gênero)
    public void recommendByGenre(String genre) {
        System.out.println("Recommended books for genre: " + genre);
        recommendByGenreRec(root, genre);
    }

    private void recommendByGenreRec(TreeNode root, String genre) {
        if (root != null) {
            recommendByGenreRec(root.left, genre);
            if (root.book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(root.book);
            }
            recommendByGenreRec(root.right, genre);
        }
    }

    // Método para imprimir todos os livros (em ordem alfabética por autor)
    public void printBooks() {
        inOrderPrint(root);
    }

    private void inOrderPrint(TreeNode root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.println(root.book);
            inOrderPrint(root.right);
        }
    }
}