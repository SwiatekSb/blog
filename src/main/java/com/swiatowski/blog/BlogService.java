package com.swiatowski.blog;

import com.swiatowski.blog.resources.IndexResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created by Piotrek on 8/15/2015.
 */
public class BlogService extends Service<BlogConfiguration> {

    public static void main(String[] args) throws Exception {
        new BlogService().run(new String[] { "server" });
    }

    @Override
    public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
        bootstrap.setName("blog");
    }

    @Override
    public void run(BlogConfiguration blogConfiguration, Environment environment) throws Exception {
        environment.addResource(new IndexResource());
    }
}
