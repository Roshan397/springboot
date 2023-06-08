# Day - 02 : JSON Annotation
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

	@GetMapping("/students/{studentId}/courses")
	public Student getCourse(@PathVariable int studentId) {
		return stdService.getCourse(studentId);
	}

	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Student getCoursewithId(@PathVariable int studentId, @PathVariable String courseId) {
		return stdService.getCoursewithId(studentId, courseId);
	}
}
```