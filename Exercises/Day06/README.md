# Day - 06 : Pagination & Sorting
## Child
```Java
@Entity
@Table(name = "child")
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int babyId;
	private String babyFirstName;
	private String babyLastName;
	private String fatherName;
	private String MotherName;
	private String address;
}
```
## Controller
```java
@RestController
public class ChildController {
	@Autowired
	ChildService cService;

	@PostMapping("/")
	public void save(@RequestBody Child c) {
		cService.save(c);
	}

	@GetMapping("/{field}")
	public List<Child> sort(@PathVariable String field) {
		return cService.sort(field);
	}

	@GetMapping("/{offset}/{pagesize}")
	public List<Child> paging(@PathVariable int offset, @PathVariable int pagesize) {
		return cService.paging(offset, pagesize);
	}

	@GetMapping("/{offset}/{pagesize}/{field}")
	public List<Child> pagingAndSorting(@PathVariable int offset, @PathVariable int pagesize,
			@PathVariable String field) {
		return cService.pagingAndSorting(offset, pagesize, field);
	}
}
```