import { Product } from 'src/app/models/Product';
//TODO: Add the contents of the order class
export class Order {
    id: number;
    name: string;
    total: number;
    price: number;
    orderItems: Product[];
  
    constructor() {
      this.id = 0; 
      this.name = '';
      this.total = 0;
      this.price = 0;
      this.orderItems = [];
    }
}