package com.projectA.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class Controller1 {

	@Autowired
	private PropConfig propConfig;

	@Value("${msg}")
	private String prop_msg;

	@Value("${role.name}")
	private String prop_role_name;

	@RequestMapping(value = "/home")
	private String home() {
		return "welcome" + " " + prop_msg + " " + prop_role_name;
	}

}
