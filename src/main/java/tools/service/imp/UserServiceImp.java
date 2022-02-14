package tools.service.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tools.mapper.UserMapper;
import tools.model.BaseResponse;
import tools.model.DataResponse;
import tools.model.user.User;
import tools.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public DataResponse<User> get(Integer id) {
		try {
			User user = userMapper.selectByPrimaryKey(id);
			return new DataResponse<User>(true, "success", user);
		} catch (Exception e) {
			return new DataResponse<User>(false, 500, e.getMessage(), null);
		}
	}

	@Override
	public DataResponse<Integer> add(User user) {
		try {
			user.setStatus(1);
			user.setCreateTime(new Date());
			userMapper.insertSelective(user);
			return new DataResponse<Integer>(true, "success", user.getId());
		} catch (Exception e) {
			return new DataResponse<Integer>(false, 500, e.getMessage(), null);
		}
	}

	@Override
	public BaseResponse update(User user) {
		try {
			userMapper.updateByPrimaryKeySelective(user);
			return new BaseResponse(true, "success");
		} catch (Exception e) {
			return new BaseResponse(false, 500, e.getMessage());
		}
	}

	@Override
	public BaseResponse delete(Integer id) {
		try {
			userMapper.deleteByPrimaryKey(id);
			return new BaseResponse(true, "success");
		} catch (Exception e) {
			return new BaseResponse(false, 500, e.getMessage());
		}
	}

}
