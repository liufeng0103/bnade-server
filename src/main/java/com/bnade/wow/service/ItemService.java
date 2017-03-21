package com.bnade.wow.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bnade.wow.dao.ItemDao;
import com.bnade.wow.dto.ItemDto;
import com.bnade.wow.entity.Item;

public class ItemService {
	
	private ItemDao itemDao = new ItemDao();
	
	public List<ItemDto> getItemsByName(String name) throws SQLException {
		List<Item> items = itemDao.getItemsByName(name);
		List<ItemDto> itemDtos = new ArrayList<>();
		for (Item item : items) {
			ItemDto itemDto = new ItemDto();
			itemDto.setId(item.getId());
			itemDto.setName(item.getName());
			itemDtos.add(itemDto);
		}
		return itemDtos;
	}
}
