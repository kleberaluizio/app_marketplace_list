package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import br.com.kleberaluizio.appmarketplace.model.ListOfItems;

import java.util.List;

public interface IListService {
    public ListOfItems createNewList(ListOfItems list);
    public void deleteList(Integer id);
    public ListOfItems closeList(Integer id);
    public ListOfItems findById(Integer id);
    public List<ListOfItems> findAll();



}
