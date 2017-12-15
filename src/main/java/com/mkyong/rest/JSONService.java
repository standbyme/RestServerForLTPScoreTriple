package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @Consumes(MediaType.APPLICATION_JSON)
    public String createTrackInJSON(Track track) {
        return track.getSinger();

    }

}