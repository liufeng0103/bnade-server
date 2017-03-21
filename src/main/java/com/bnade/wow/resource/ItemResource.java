package com.bnade.wow.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bnade.wow.dto.ItemDto;
import com.bnade.wow.service.ItemService;

@Path("/items")
public class ItemResource {

	private static Logger logger = LoggerFactory.getLogger(ItemResource.class);

	private ItemService itemService = new ItemService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDto> getItemsByName(@QueryParam("name") String name) {
		try {
			return itemService.getItemsByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

}
