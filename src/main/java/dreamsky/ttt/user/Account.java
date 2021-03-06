package dreamsky.ttt.user;

import org.springframework.util.Assert;

public class Account {
	private long userId;
	private long totalBalance;
	private long availableBalance;
	private int version;
	
	public void deposit(long money) {
		Assert.isTrue(money > 0);
		this.totalBalance += money;
		this.availableBalance += money;
	}
	
	public boolean withdraw(long money) {
		Assert.isTrue(money > 0);
		if (this.availableBalance < money) return false;
		this.availableBalance -= money;
		this.totalBalance -= money;
		return true;
	}
	
	public boolean freeze(long money) {
		Assert.isTrue(money > 0);
		if (this.availableBalance < money) return false;
		this.availableBalance -= money;
		return true;
	}
	
	public void refund(long money) {
		Assert.isTrue(money > 0);
		this.availableBalance += money;
	}
	
	public void confirmPay(long money) {
		Assert.isTrue(money > 0);
		this.totalBalance -= money;
	}
	
	public void receivePay(long money) {
		Assert.isTrue(money > 0);
		this.availableBalance += money;
		this.totalBalance += money;
	}
	
	long getUserId() {
		return userId;
	}
	void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTotalBalance() {
		return totalBalance;
	}
	void setTotalBalance(long totalBalance) {
		this.totalBalance = totalBalance;
	}
	public long getAvailableBalance() {
		return availableBalance;
	}
	void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}
	int getVersion() {
		return version;
	}
	void setVersion(int version) {
		this.version = version;
	}
}
