package com.imt.framework.com.Uber;

import com.imt.framework.com.Uber.resources.PlatResources;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("uber")
@Configuration
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){
        register(PlatResources.class);
    }
}
