package com.swiatowski.blog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Piotrek on 8/15/2015.
 */
public class BlogConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    public String mongohost = "localhost";

    @JsonProperty
    @Min(1)
    @Max(65535)
    public int mongoport = 27017;

    @JsonProperty
    @NotEmpty
    public String mongodb = "mydb";
}
