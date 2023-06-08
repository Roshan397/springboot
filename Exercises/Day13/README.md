# Day - 13 : Bidirectional & OneToMany
## Author
```Java
@Entity
@Table(name="author")
public class Author {
	@Id
	private int authorid;
	private String authorbook;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="author_book")
	private List<Book> bookinfo;
}
```
## Book
```java
@Entity
@Table(name="book")
public class Book {
	@Id
	private int bookid;
	private String booktitle;
}
```