package com.swiatowski.blog;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.swiatowski.blog.representations.Blog;
import com.swiatowski.blog.resources.BlogResource;
import com.swiatowski.blog.resources.IndexResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import net.vz.mongodb.jackson.JacksonDBCollection;

/**
 * Created by Piotrek on 8/15/2015.
 */
public class BlogService extends Service<BlogConfiguration> {

    public static void main(String[] args) throws Exception {
        new BlogService().run(new String[]{"server"});
    }

    @Override
    public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
        bootstrap.setName("blog");
    }

    @Override
    public void run(BlogConfiguration blogConfiguration, Environment environment) throws Exception {
        Mongo mongo = new Mongo(blogConfiguration.mongohost, blogConfiguration.mongoport);
        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.manage(mongoManaged);

        environment.addHealthCheck(new MongoHealthCheck(mongo));

        DB db = mongo.getDB(blogConfiguration.mongodb);
        JacksonDBCollection<Blog, String> blogs = JacksonDBCollection.wrap(db.getCollection("blogs"), Blog.class, String.class);

        environment.addResource(new IndexResource(blogs));
        environment.addResource(new BlogResource(blogs));
    }
}
