package dreamsky.ttt.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
	@Autowired UserDao userDao;
	@Autowired AccountDao accountDao;
	@Autowired AddressDao addressDao;

	@Transactional
	public User register(User user) {
		User checkDuplicate = userDao.findByUnique("login", user.getLogin());
		if (checkDuplicate != null) throw new DuplicateLoginException();
		
		checkDuplicate = userDao.findByUnique("email", user.getEmail());
		if (checkDuplicate != null) throw new DuplicateEmailException();
		
		userDao.save(user);
		
		Account account = new Account();
		account.setUserId(user.getId());
		account.setAvailableBalance(0);
		account.setTotalBalance(0);
		accountDao.save(account);
		
		return user;
	}
	
	@Transactional(readOnly=true)
	public User login(String login, String password) {
		User user = userDao.findByUnique("login", login);
		if (user != null && user.checkPassword(password)) {
			return user;
		}
		return null;
	}
	
	@Transactional(readOnly=true) 
	public User get(Long id) {
		return userDao.get(id);
	}
	
	@Transactional
	public void saveAddress(Address address) {
		addressDao.save(address);
	}
	
	@Transactional(readOnly=true)
	public List<Address> findAddresses(Long userId) {
		return addressDao.findBy("userId", userId);
	}
	
	@Transactional
	public void deleteAddress(Long addressId) {
		addressDao.delete(addressId);
	}
}
