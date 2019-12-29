package com.tech.auth;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tech.auth.common.pageutil.pageResult;
import com.tech.auth.user.dao.UserServiceDao;
import com.tech.auth.user.entity.PageVO;
import com.tech.auth.user.entity.UserVo;
import java.util.List;
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


	/*@Bean
	public PageInterceptor[] pageInterceptors() {
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("reasonable", "false");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "count=check");
		properties.setProperty("params", "count=countSql");
		pageInterceptor.setProperties(properties);
		return new PageInterceptor[] { pageInterceptor };
	}
*/
	@GetMapping("/welcome/{str}")
	public Boolean welcome(@PathVariable final String str){
		logger.info("entering to the metod");
		if (str == null){
			return false;
		}
		Boolean ret = false;
		PageVO pageVO = new PageVO();
		pageVO.setPageSize(15);
		pageVO.setPageNum(1);

		Page<Object> page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageNum());

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

	@GetMapping("/finAlldUser/{currPage}/{pageSize}")
	public pageResult<UserVo> findAllUser(@PathVariable("currPage") int currPage,
										  @PathVariable("pageSize") int pageSize){
		PageVO pageVO = new PageVO();
		pageVO.setPageNum(currPage);
		pageVO.setPageSize(pageSize);
		Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<UserVo>userVoList = userServiceDao.findAllUser();
		pageVO.setTotalRows((int) page.getTotal());
		pageVO.setTotalPages(page.getPages());
		return new pageResult<UserVo>(userVoList, pageVO);
	}



}
