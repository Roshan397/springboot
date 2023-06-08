# Day - 10 : SELECT, UPDATE, DELETE with JPQL
## Student
```Java
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentname;
	@JsonIgnore
	private String department;
	@JsonIgnore
	private String email;
	private String courseId;
	private String coursename;
}
```
## Controller
```java
	@RestController
	public class StudentController {
	@Autowired
	StudentService stdService;

	@GetMapping("/getStudentByCourse/{cname}")
	public List<Student> getStudentByCourse(@PathVariable String cname) {
		return stdService.getStudentByCourse(cname);
	}
	
	@PutMapping("/updateNameById/{name}/{id}")
	public int updateNameById(@PathVariable String name,@PathVariable int id) {
		return stdService.updateNameById(name,id);
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public int deletebyId(@PathVariable int id) {
		return stdService.deletebyId(id);
	}
}
```