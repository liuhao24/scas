package com.yanalysis.oathink;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.yanalysis.oathink.system.endpoint.OrgnSettingEndpoint;
import com.yanalysis.oathink.user.endpoint.ReverseEndpoint;
import com.yanalysis.oathink.user.endpoint.UserEndpoint;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(ReverseEndpoint.class);
		register(UserEndpoint.class);
		register(OrgnSettingEndpoint.class);
	}

}
