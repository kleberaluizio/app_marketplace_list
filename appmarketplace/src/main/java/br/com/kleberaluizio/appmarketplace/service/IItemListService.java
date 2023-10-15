package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.ItemList;

public interface IItemListService {
    public ItemList insertItem(ItemList item);
    public ItemList updateItem(ItemList item);
    public void deleteItem(Integer id);
    public ItemList findById(Integer id);

}
