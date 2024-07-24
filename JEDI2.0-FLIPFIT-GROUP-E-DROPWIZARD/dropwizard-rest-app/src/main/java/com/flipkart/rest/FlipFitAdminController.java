package com.flipkart.rest;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymApprovalRequest;
import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitGymCenterService;
import com.flipkart.business.FlipFitGymOwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitAdminController {
    private static FlipFitAdminService adminService = new FlipFitAdminService();
    private static FlipFitGymOwnerService gymOwnerService = new FlipFitGymOwnerService();
    private static FlipFitGymCenterService gymCenterService = new FlipFitGymCenterService();

    public FlipFitAdmin isUserValid(String userName, String password) {
        FlipFitAdmin admin = new FlipFitAdmin();
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return admin;
        }
        return null;
    }

    @GET
    @Path("/login")
    @Timed
    public Response customerLogin(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        FlipFitAdmin admin = null;
        try{
            admin = isUserValid(userName, password);
            System.out.println("Login Successful");
            return Response.ok(admin).build();
        }catch (Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-owner/pending-list")
    @Timed
    public Response viewPendingGymOwners() {
        try{
            List<FlipFitGymOwner> gymOwnerList = adminService.viewPendingGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-owner/all")
    @Timed
    public Response viewGymOwners(){
        try{
            List<FlipFitGymOwner> gymOwnerList = gymOwnerService.viewAllGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-centre/all")
    public Response viewAllGymCenters() {
        try{
            List<FlipFitGymCenter> gymCenterList = gymCenterService.viewAllGymCenters();
            return Response.ok(gymCenterList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-centre/pending-list")
    @Timed
    public Response viewPendingGymCentres(){
        try{
            List<FlipFitGymCenter> gymCentreList = adminService.viewPendingGymCentres();
            return Response.ok(gymCentreList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/gym-owner/handle")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleGymOwner(FlipFitGymApprovalRequest approvalRequest){
        try{
            adminService.approveGymOwner(approvalRequest.getId(), approvalRequest.getChoice());
            return Response.ok("Request Handled").build();
        } catch (Exception e){
            return Response.status(400).entity("Invalid Gym Owner details").build();
        }

    }

    @POST
    @Path("/gym-centre/handle")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleGymCentre(FlipFitGymApprovalRequest approvalRequest){
        try{
            adminService.approveGymCenter(approvalRequest.getId(), approvalRequest.getChoice());
            return Response.ok("Request Handled").build();
        } catch (Exception e){
            return Response.status(400).entity("Invalid Gym Centre details").build();
        }

    }

}
