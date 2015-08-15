package com.swiatowski.blog;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;

/**
 * Created by Piotrek on 8/15/2015.
 */
public class MongoHealthCheck extends HealthCheck {

    private Mongo mongo;

    protected MongoHealthCheck(Mongo mongo) {
        super("MongoDBHealthCheck");
        this.mongo = mongo;
    }
    
    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }
}
