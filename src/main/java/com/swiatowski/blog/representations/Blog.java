package com.swiatowski.blog.representations;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Piotrek on 8/15/2015.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Blog {

    private String id = UUID.randomUUID().toString();

    @NotBlank
    private String title;

    @URL
    @NotBlank
    private String url;

    private final Date publishedOn = new Date();

    public Blog() {
    }

    public Blog(String title, String url) {
        super();
        this.title = title;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }
}

