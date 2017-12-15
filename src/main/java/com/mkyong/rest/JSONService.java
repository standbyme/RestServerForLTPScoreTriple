package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Result;
import com.scir.hypernym.webservice.dealResult;
import com.model.Triple;
import com.model.TripleWithSSIDs;

import java.util.ArrayList;

@Path("/score")
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
    public Result createTrackInJSON(TripleWithSSIDs triple_with_ssid_s) {
        dealResult Dealer = new dealResult();
        Result result = new Result(Dealer.pack(triple_with_ssid_s.triple_with_ssid_s));
        return result;
    }
}