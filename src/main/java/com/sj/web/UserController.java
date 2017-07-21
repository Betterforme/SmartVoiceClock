package com.sj.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sj.dto.AppointExecution;
import com.sj.dto.Result;
import com.sj.entity.Book;
import com.sj.entity.ResultBean;
import com.sj.entity.User;
import com.sj.enums.AppointStateEnum;
import com.sj.exception.NoNumberException;
import com.sj.exception.RepeatAppointException;
import com.sj.service.BookService;
import com.sj.service.UserService;
import com.sj.util.Sutil;

import constants.Constants;

@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public ResultBean result = new ResultBean();
	
	public void setServiceError(){
		result.setResultObject(Constants.TIP_SVRVICE_ERROR);
		result.setResultCode("1");
	}
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	private Object login(User model) {
		try {
			User user = userService.getUserById(model.getUserid());
			if(user == null){
				result.setResultObject(Constants.TIP_LOGGIN_UNREGIST);
				result.setResultCode("102");
			}else if(user.getPassword().equals(model.getPassword())){
				result.setResultObject(user);
				result.setResultCode("0");
			}else{
				result.setResultObject(Constants.TIP_LOGGIN_PASSWORD_ERROR);
				result.setResultCode("101");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setServiceError();
		}
		// list.jsp + model = ModelAndView
		return result;// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	@ResponseBody
	private Object regist(User model) {
		try {
			if(!Sutil.isEorN(model.getPassword()) && !Sutil.isEorN(model.getUsername())){
				User userid = userService.userRegist(model);
				result.setResultObject(userid);
				result.setResultCode("0");
			}else{
				result.setResultObject(model);
				result.setResultCode("0");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setServiceError();
		}
		return result;
	}
//
//	// ajax json
//	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
//			"application/json; charset=utf-8" })
//	@ResponseBody
//	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
//		if (studentId == null || studentId.equals("")) {
//			return new Result<>(false, "学号不能为空");
//		}
//		AppointExecution execution = null;
//		try {
//			execution = bookService.appoint(bookId, studentId);
//		} catch (NoNumberException e1) {
//			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
//		} catch (RepeatAppointException e2) {
//			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
//		} catch (Exception e) {
//			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
//		}
//		return new Result<AppointExecution>(true, execution);
//	}

}
