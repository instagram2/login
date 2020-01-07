package v1.resources;

import lib.User;
import services.beans.UserBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@ApplicationScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
    @Inject
    private UserBean userBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getUser() {
        List<User> imageMetadata = userBean.getUserFilter(uriInfo);
        return Response.status(Response.Status.OK).entity(imageMetadata).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") Integer userId) {

        User user = userBean.getUser(userId);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(user).build();
    }

    @POST
    public Response createUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || user.getEmail() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            user = userBean.createUser(user);
        }
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser (@PathParam("userId") Integer userId, User user) {
        user = userBean.updateUser(userId, user);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser (@PathParam("userId") Integer userId) {
        boolean deleted = userBean.deleteUser(userId);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
