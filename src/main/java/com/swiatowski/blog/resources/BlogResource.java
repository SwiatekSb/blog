package com.swiatowski.blog.resources;

import com.swiatowski.blog.representations.Blog;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Piotrek on 8/15/2015.
 */
@Path("/blogs")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BlogResource {

    private JacksonDBCollection<Blog, String> collection;

    public BlogResource(JacksonDBCollection<Blog, String> blogs) {
        this.collection = blogs;
    }

    @POST
    @Timed
    public Response publishNewBlog(@Valid Blog blog) {
        collection.insert(blog);
        return Response.noContent().build();
    }
}
