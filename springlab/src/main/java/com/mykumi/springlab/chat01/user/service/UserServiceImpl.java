package com.mykumi.springlab.chat01.user.service;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;

import com.mykumi.springlab.chat01.Level;
import com.mykumi.springlab.chat01.User;
import com.mykumi.springlab.chat01.UserDao;

public class UserServiceImpl implements UserService {
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;
	public static final int MIN_LOGINCOUNT_FOR_SILVER = 50;
	private UserDao userDao;
	private MailSender mailSender;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void upgradeLevels() {
		List<User> users = userDao.getAll();

		for (User user : users) {
			if (this.canUpgradeLevel(user) == true) {
				this.upgradeLevel(user);
			}
		}
	}

	protected boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		switch (currentLevel) {
		case BASIC:
			return (user.getLogin() >= MIN_LOGINCOUNT_FOR_SILVER);
		case SILVER:
			return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level : "
					+ currentLevel);
		}
	}

	protected void upgradeLevel(User user) {
		user.upgradeLevel();
		userDao.update(user);
		sendUpgradeEMail(user);
	}

	private void sendUpgradeEMail(User user) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("useradmin@ksug.org");
		mailMessage.setSubject("Upgrade 안내");
		mailMessage.setText("사용자님의 등급이 " + user.getLevel().name()
				+ "로 업그레이드 되었습니다.");

		this.mailSender.send(mailMessage);
	}

	// 레벨이 설정되어 있지 않은 경우 BASIC 레벨로 설정한다.
	@Override
	public void add(User user) {
		if (user.getLevel() == null)
			user.setLevel(Level.BASIC);
		userDao.add(user);
	}
}
