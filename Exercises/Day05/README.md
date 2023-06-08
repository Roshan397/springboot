# Day - 05 : PUT & DELETE
## Product
```Java
@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private float price;
	private int quantity;
	private String description;
}
```
## Controller
```java
@RestController
public class ProductController {
	@Autowired
	ProductService pService;

	@PostMapping("/")
	public boolean save(@RequestBody Product p) {
		boolean result = pService.save(p);
		return result;
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable int id) {
		Product p = pService.getById(id);
		return p;
	}

	@GetMapping("/")
	public List<Product> getAll() {
		List<Product> pList = pService.getAll();
		return pList;
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable int id, @RequestBody Product p) {
		Product prod = pService.update(id, p);
		return prod;
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		boolean result = pService.delete(id);
		return result;
	}
}
```