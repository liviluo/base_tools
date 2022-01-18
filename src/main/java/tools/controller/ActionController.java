package tools.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ActionController {

	@RequestMapping(value = "data", method = RequestMethod.GET)
	public Map<String, String> get(String id) throws Exception {
		System.out.println("***/api/data:get***");
		System.out.println("id: " + id);
		Map<String, String> result = new HashMap<>();
		result.put("method", "get");
		return result;
	}

	@RequestMapping(value = "data", method = RequestMethod.POST)
	public Map<String, String> post(@RequestBody(required = false) Map<String, String> map) {
		System.out.println("***/api/data:post***");
		if (map != null) {
			for (String key : map.keySet()) {
				System.out.println("key: " + key + ", value: " + map.get(key));
			}
		}
		Map<String, String> result = new HashMap<>();
		result.put("method", "post");
		return result;
	}

}