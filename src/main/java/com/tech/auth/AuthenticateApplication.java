package com.tech.auth;

import com.tech.auth.user.dao.UserServiceDao;
import com.tech.auth.user.entity.UserVo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

@SpringBootApplication
@MapperScan("com.tech.auth.**.dao")
@RestController
@RequestMapping("/hello")
public class AuthenticateApplication {
	private static Logger logger = LoggerFactory.getLogger(AuthenticateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateApplication.class, args);
	}

	@Autowired
	private UserServiceDao userServiceDao;

	@GetMapping("/welcome/{str}")
	public Boolean welcome(@PathVariable final String str){
		logger.info("entering to the metod");
		if (str == null){
			return false;
		}
		Boolean ret = false;
		UserVo vo = new UserVo();
		if (null != str){
			vo = userServiceDao.findUser(str);
			if (vo == null){
				return false;
			}
			if (vo.getUserId().equals(str)){
				ret = true;
			}
			else
				ret = false;

		}else
			ret = false;
		logger.info("existing to the metod");
		return ret;

	}


}
