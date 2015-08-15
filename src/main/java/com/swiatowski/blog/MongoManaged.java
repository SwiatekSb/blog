package com.swiatowski.blog;

import com.mongodb.Mongo;
import com.yammer.dropwizard.lifecycle.Managed;

/**
 * Created by Piotrek on 8/15/2015.
 */
public class MongoManaged implements Managed {
    private Mongo mongo;

    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }
}
