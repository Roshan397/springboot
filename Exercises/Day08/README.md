# Day - 08 : STARTS & ENDS with Query
## Dog
```Java
@Entity
@Table(name = "dog")
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int age;
}
```
## Controller
```java
@RestController
public class DogController {
	@Autowired
	DogService dService;

	@GetMapping("/findByNameStartsWith")
	List<Dog> findByNameStartsWith(String name) {
		return dService.findByNameStartsWith(name);
	}

	@GetMapping("/findByNameEndsWith")
	List<Dog> findByNameEndsWith(String name) {
		return dService.findByNameEndsWith(name);
	}
}
```