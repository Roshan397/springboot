# Day - 11 : Relationship Mapping & OneToOne
## Person
```java
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
}
```
## Address
```Java
@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String zipcode;
}
```