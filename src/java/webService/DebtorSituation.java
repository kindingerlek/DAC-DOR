/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.entities.Company;
import models.entities.DebtorCompanySituation;
import models.entities.Debtor;
import models.entities.DebtorCompanySituationId;

/**
 * REST Web Service
 *
 * @author Alisson
 */
@Path("debtorSituation")
public class DebtorSituation {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DebtorSituation
     */
    public DebtorSituation() {
    }

    /**
     * Retrieves representation of an instance of
     * models.entities.DebtorSituation
     *
     * @return an instance of models.entities.DebtorCompanySituation
     */
    @GET
    public Response getJson(@QueryParam("debtorIdentifier") String debtorIdentifier) {
        Debtor debtor = new Debtor();
        debtor.setIdentifier(debtorIdentifier);
        debtor = debtor.getDebtor();
        if (debtor == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for identifier: " + debtorIdentifier).build();
        } else {
            DebtorActualSituation situation = new DebtorActualSituation();
            situation.setIdentifier(debtorIdentifier);
            situation.setIndebt(debtor.isIndebted());
            return Response.ok(situation, MediaType.APPLICATION_JSON).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of DebtorSituation
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response putJson(DebtorCompanySituationWeb debtorCompanySituation) {
        String token = debtorCompanySituation.getCompanyToken();
        String identifier = debtorCompanySituation.getDebtorIdentifier();
        Company company = new Company();
        company.setToken(token);
        company = company.getCompany();
        if (company == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for token: " + token).build();
        }
        Debtor debtor = new Debtor();
        debtor.setIdentifier(identifier);
        debtor = debtor.getDebtor();

        if (debtor == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for identifier: " + identifier).build();
        }

        DebtorCompanySituation debtorCompanySituationToUpdate;
        debtorCompanySituationToUpdate = new DebtorCompanySituation(company, debtor);
        debtorCompanySituationToUpdate.setIndebt(debtorCompanySituation.isIndebt());
        if (!debtorCompanySituationToUpdate.saveOrUpdate()) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Sever Error, can't update that resource.").build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
        //return Response.ok(, MediaType.APPLICATION_JSON).build();

    }
}
