# Day - 01 : RequestParam & PathVariable
## Controller
```java
@RestController
public class Controller {
	@RequestMapping("/")
	public String requestparam(@RequestParam String var) {
		return var;
	}

	@RequestMapping("/{var}")
	public String pathvariable(@PathVariable String var) {
		return var;
	}
}
```