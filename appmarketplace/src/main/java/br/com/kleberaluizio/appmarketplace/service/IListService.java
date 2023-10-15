package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import br.com.kleberaluizio.appmarketplace.model.ListOfItems;

public interface IListService {
    public ListOfItems createNewList(ListOfItems list);
    public void deleteList(Integer id);
    public void closeList(Integer id);
    public void findById(Integer id);



}
