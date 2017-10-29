package com.jfeesoft.watchserver2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderRestController {

	@Autowired
	private WatchService watchService;

	@RequestMapping(value = "/order/{command}", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public void getUser(@PathVariable("command") String command) {
		watchService.sendCommand(command);
	}

}
