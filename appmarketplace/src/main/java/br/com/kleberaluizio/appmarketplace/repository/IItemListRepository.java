package br.com.kleberaluizio.appmarketplace.repository;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import org.springframework.data.repository.CrudRepository;

public interface IItemListRepository extends CrudRepository<ItemList, Integer> {
}
