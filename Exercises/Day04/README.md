# Day - 04 : GET & POST
## Books
```Java
@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookName;
}
```
## Controller
```java
@RestController
@RequestMapping("/api")
public class BooksController {
	@Autowired
	BooksService bService;

	@GetMapping("/books")
	public List<Books> getAll() {
		List<Books> booksList = bService.getAll();
		return booksList;
	}

	@PostMapping("/saveBook")
	public Books save(@RequestBody Books b) {
		Books book = bService.save(b);
		return book;
	}

	@PutMapping("/books")
	public Books update(@RequestBody Books b) {
		Books book = bService.update(b);
		return book;
	}

	@DeleteMapping("/book/{bookId}")
	public void delete(@PathVariable int bookId) {
		bService.delete(bookId);
	}
}
```