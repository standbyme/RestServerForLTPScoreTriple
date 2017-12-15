package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mkyong.Result;
import com.mkyong.Track;
import com.mkyong.Triple;

import java.util.ArrayList;

@Path("/json/metallica")
public class JSONService {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Triple> getTrackInJSON() {

        Triple t = new Triple("Harry", "Love", "Apple");
        Triple r = new Triple("Kid", "Love", "Milk");

        ArrayList<Triple> result = new ArrayList<Triple>();

        result.add(t);
        result.add(r);


        return result;

    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result createTrackInJSON(Track track) {
        Result result = new Result();
        result.result.add(22.59);
        return result;
    }

}