import { List } from "./List";
import { Product } from "./Product";

export class ItemList{
    public id: number = 0;
    public quantity: number = 0;
    public totalPrice: number = 0;
    public finished: number = 0;
    public product: Product = new Product();
    // public list: List = new List();
}