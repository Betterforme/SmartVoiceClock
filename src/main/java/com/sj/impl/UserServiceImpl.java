package com.sj.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sj.dao.AppointmentDao;
import com.sj.dao.BookDao;
import com.sj.dao.UserMapper;
import com.sj.dto.AppointExecution;
import com.sj.entity.Appointment;
import com.sj.entity.Book;
import com.sj.entity.User;
import com.sj.enums.AppointStateEnum;
import com.sj.exception.AppointException;
import com.sj.exception.NoNumberException;
import com.sj.exception.RepeatAppointException;
import com.sj.service.BookService;
import com.sj.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖

	@Autowired
	private UserMapper userMapper; 
	
	@Override
	public User getUserById(long userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return userMapper.queryAll();
	}

	@Override
	public int userLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	@Override
	public User userRegist(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
//	@Override
//	public Book getById(long bookId) {
//		return bookDao.queryById(bookId);
//	}
//
//	@Override
//	public List<Book> getList() {
//		return bookDao.queryAll(0, 1000);
//	}

	
	
	
//	@Override
//	@Transactional
//	/**
//	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
//	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
//	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
//	 */
//	public AppointExecution appoint(long bookId, long studentId) {
//		try {
//			// 减库存
//			int update = bookDao.reduceNumber(bookId);
//			if (update <= 0) {// 库存不足
//				throw new NoNumberException("no number");
//			} else {
//				// 执行预约操作
//				int insert = appointmentDao.insertAppointment(bookId, studentId);
//				if (insert <= 0) {// 重复预约
//					throw new RepeatAppointException("repeat appoint");
//				} else {// 预约成功
//					Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
//					return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
//				}
//			}
//		} catch (NoNumberException e1) {
//			throw e1;
//		} catch (RepeatAppointException e2) {
//			throw e2;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			// 所有编译期异常转换为运行期异常
//			throw new AppointException("appoint inner error:" + e.getMessage());
//		}
//	}

}
