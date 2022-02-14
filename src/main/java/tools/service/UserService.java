package tools.service;

import tools.model.BaseResponse;
import tools.model.DataResponse;
import tools.model.user.User;

public interface UserService {

	public DataResponse<User> get(Integer id);

	public DataResponse<Integer> add(User user);

	public BaseResponse update(User user);

	public BaseResponse delete(Integer id);

}
