package com.smith.facts.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.smith.facts.bean.Facts;
import com.smith.facts.business.service.FactService;
import com.smith.facts.resources.Factory;
import com.smith.facts.resources.JSONParser;

@Path("FactAPI")
public class FactAPI {
	
	// gets the category
	@GET
	@Path("category/{cat}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFactCategory(@PathParam("cat") String category)
			throws Exception {
		Response response = null;

		try {
			FactService ser = Factory.createFactService();
			List<String> factList = ser.getFactsCategory(category);

			String returnString = JSONParser.toJson(factList);

			response = Response.ok(returnString).build();
		} catch (Exception e) {

			Facts msg = new Facts();
			msg.setErrMsg((e.getMessage()));
			String returnString = JSONParser.toJson(msg);
			if (e.getMessage().contains("DATABASE")) {
				response = Response.status(Status.SERVICE_UNAVAILABLE)
						.entity(returnString).build();
			} else {
				response = Response.status(Status.BAD_REQUEST)
						.entity(returnString).build();

			}
		}

		return response;
	}

	// get distinct categories
	@GET
	@Path("distinctCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDistinctCategories() throws Exception {
		Response response = null;
		try {
			FactService factService = Factory.createFactService();
			List<String> categoryList = factService.getDistinctcatergories();

			String returnString = JSONParser.toJson(categoryList);

			response = Response.ok(returnString).build();
		} catch (Exception e) {

			Facts msg = new Facts();
			msg.setErrMsg((e.getMessage()));
			String returnString = JSONParser.toJson(msg);
			if (e.getMessage().contains("DATABASE")) {
				response = Response.status(Status.SERVICE_UNAVAILABLE)
						.entity(returnString).build();
			} else {
				response = Response.status(Status.BAD_REQUEST)
						.entity(returnString).build();

			}
		}
		return response;
	}

	// count of facts in each category
	@GET
	@Path("countFacts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountFacts() throws Exception {
		Response response = null;
		try {

			FactService factService = Factory.createFactService();
			List<Integer> noOfFacts = factService.getCountCategories();

			String returnString = JSONParser.toJson(noOfFacts);

			response = Response.ok(returnString).build();
		} catch (Exception e) {

			Facts msg = new Facts();
			msg.setErrMsg((e.getMessage()));
			String returnString = JSONParser.toJson(msg);
			if (e.getMessage().contains("DATABASE")) {
				response = Response.status(Status.SERVICE_UNAVAILABLE)
						.entity(returnString).build();
			} else {
				response = Response.status(Status.BAD_REQUEST)
						.entity(returnString).build();

			}
		}
		return response;
	}

}
