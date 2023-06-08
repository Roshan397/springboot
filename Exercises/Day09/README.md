# Day - 09 : JPQL With @Query Annotation
## User
```Java
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String emailAddress;
}
```
## Controller
```java
@RestController
public class UserController {
	@Autowired
	UserService uService;

	@GetMapping("/findByEmailAddress")
	public User findByEmailAddress(String emailAddress) {
		return uService.findByEmailAddress(emailAddress);
	}

	@GetMapping("/findByNameEndsWith")
	public List<User> findByNameEndsWith(String name) {
		return uService.findByNameEndsWith(name);
	}
}
```