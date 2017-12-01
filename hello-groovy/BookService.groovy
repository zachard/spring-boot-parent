interface BookService {

	List<Book> findByReader(String reader)

	void save(Book book)

}
