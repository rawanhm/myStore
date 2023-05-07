import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/Order';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  cartProducts: any[] = [];
  private baseUrl: string = 'http://localhost:8080/orders/';
  constructor(private http: HttpClient) { }

  getCartProducts() {
    return this.cartProducts;
  }

  addToCart(product: any, amount: any) {
    //TODO: Add item to the cart 
    let existingProduct = this.cartProducts.find((prod) => {
      prod.name === product.name;
    });
    if (existingProduct) {
      existingProduct.amount += parseInt(amount);
    } else {
      this.cartProducts.push(product);
    }
     
    alert(`${product.name} has been added to cart!`);
    }

  
 

  clearCart() {
    this.cartProducts = [];
    return this.cartProducts;
  }

  updateCart(cart: any) {
    this.cartProducts = cart;

    return this.cartProducts;
  }

  submitOrder(order: any): Observable<any> {
  //Submit the order information the API
  return this.http.post<Order>(this.baseUrl+'new', order, {
    headers: { Authorization: 'Basic dWRhY2l0eTpwYXNzd29yZA==' },
  });
  }
}
