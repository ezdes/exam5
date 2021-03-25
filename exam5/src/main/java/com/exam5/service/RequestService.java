package com.exam5.service;

import com.exam5.dao.RequestDao;
import com.exam5.model.Request;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/request")
public class RequestService {
    private final RequestDao requestDao = new RequestDao();

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String createRequest(Request request) {
        requestDao.addRequest(request);
        return request.getBirthYear() < 2000 ?
                "Error! Birth year is less than 2000" : request.getGender().equals("male") || request.getGender().equals("female") ?
                request.getGender().equals("male")
                        ? "Уважаемый " + request.getName()
                        + ", Ваш год рождения: " + request.getBirthYear() + ", вам: " +
                        (LocalDate.now().getYear() - request.getBirthYear()) + " лет" : "Уважаемая " + request.getName()
                        + ", Ваш год рождения: " + request.getBirthYear() + ", вам: " +
                        (LocalDate.now().getYear() - request.getBirthYear()) + " лет" : "Incorrect gender!";
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Request> getAllRequests() {
        return requestDao.getAllRequest();
    }

    @GET
    @Path("/byName/{requestName}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Request> getRequestsByName(@PathParam("requestName") String name) {
        return requestDao.getRequestByName(name);
    }

    @GET
    @Path("/byGender/{requestGender}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Request> getRequestsByGender(@PathParam("requestGender") String gender) {
        return requestDao.getRequestByGender(gender);
    }

    @GET
    @Path("/byBirthYear/{requestBirthYear}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Request> getRequestsByBirthYear(@PathParam("requestBirthYear") Integer birthYear) {
        return requestDao.getRequestByBirthYear(birthYear);
    }

    @DELETE
    @Path("/{requestId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String deleteRequestById(@PathParam("requestId") Long id) {
        return requestDao.deleteRequestById(id);
    }
}
