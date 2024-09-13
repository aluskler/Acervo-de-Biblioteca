package library;

public class BooksList {
	public Book[] books;
	public int size;

	public BooksList(int listCapacity) {
		books = new Book[listCapacity];
		size = 0;
	}

	public void addBook(Book book) {
		if (books.length == size) {
			Book[] newList = new Book[books.length * 2];
			for (int i = 0; i < books.length; i++) {
				newList[i] = books[i];
			}
			books = newList;
		}
		books[size] = book;
		size++;
	}

	public void addBookOld(Book book) {
		if (size < books.length) {
			books[size] = book;
			size++;
		} else {
			System.out.println("The list is full!");
			System.out.println("OBS: NEED TO ADD THE LOGIC TO DOUBLE THE LIST LENGHT!");
		}
	}

	public void removeBook(int index){
		Book[] newListFiltered = new Book[books.length];
		for (int i = 0; i < books.length; i++) {
			if (index != i){
				newListFiltered[i] = books[i];
			}
		}
		this.books = newListFiltered;
		size--;
	} 

	public void printBooks() {
		for (int i = 0; i < size; i++) {
			System.out.println(books[i]);
		}
	}

	public int listSize() {
		return size;
	}

	public void sortByTitle() {
		quickSortByTitle(0, size - 1);
	}

	public void sortByAuthor() {
		quickSortByAuthor(0, size - 1);
	}

	private void quickSortByTitle(int start, int end) {
		if (start < end) {
			int pivotIndex = partitionByTitle(start, end);
			quickSortByTitle(start, pivotIndex - 1);
			quickSortByTitle(pivotIndex + 1, end);
		}
	}

	private int partitionByTitle(int start, int end) {
		Book pivot = books[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (books[j].getTitle().compareTo(pivot.getTitle()) <= 0) {
				i++;
				books[i] = books[j];
			}
		}

		Book temp = books[i + 1];
		books[i + 1] = books[end];
		books[end] = temp;

		return i + 1;
	}

	private void quickSortByAuthor(int start, int end) {
		if (start < end) {
			int pivotIndex = partitionByAuthor(start, end);
			quickSortByAuthor(start, pivotIndex - 1);
			quickSortByAuthor(pivotIndex + 1, end);
		}
	}

	private int partitionByAuthor(int start, int end) {
		Book pivot = books[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (books[j].getAuthor().compareTo(pivot.getAuthor()) <= 0) {
				i++;
				Book temp = books[i];
				books[i] = books[j];
				books[j] = temp;
			}
		}

		Book temp = books[i + 1];
		books[i + 1] = books[end];
		books[end] = temp;
		return i + 1;
	}

}
