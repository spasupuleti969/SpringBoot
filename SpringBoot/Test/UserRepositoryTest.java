import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.repository.UserRepository;

public class UserRepositoryTest {

	@InjectMocks
	public UserRepository userRepository;

	public void testAddUser() {

		Mockito.when(userRepository.userData()).thenReturn(userList());
		
		String userId = userRepository.addUser(user);
		
		Assert.assertNotNull(userId);

		
	}

	private List<User> userList() {
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setActive(true);
		user.setEmail("spasupuleti969@gmail.com");
		user.setId("123");
		user.setBirthDate(LocalDate.of(1993, Month.FEBRUARY, 10));
		user.setfName("Sudharsan");
		user.setlName("Pasupuleti");
		user.setPinCode(600099);
		userList.add(user);
		return userList;
	}

}
