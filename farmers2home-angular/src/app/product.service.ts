import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  addProductToOrder(newProduct: Product) {
    throw new Error('Method not implemented.');
  }

  rootURL: string;

// declare the client object in constructor to use in this service.
  constructor(private httpsvc:HttpClient) { 
    this.rootURL="http://localhost:7777/farmertomarket"
  }

  addProductToFarmer(farmerId:number, productId:number):Observable<Product[]>{
    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
      }

      var reqBody = "farmerId="+farmerId+"&productId="+productId

      return this.httpsvc.post<Product[]>(
        this.rootURL+"/farmer_to_product_assignment/", reqBody, httpOpts
      )
  }
  

  addNewProduct(newProduct: Product) {
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('productName', newProduct.productName)
    params.set('productDescription', newProduct.productDescription)
    params.set('productType', newProduct.productType)

    return this.httpsvc.post<Product>(this.rootURL+"/product/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  
    }

  findProductsByFarmerNo(farmerId:number):Observable<Product[]>{
    return this.httpsvc.get<Product[]>(this.rootURL+"/product/"+farmerId)
  }

  registerProductsForFarmer(farmerId:number,newProduct:Product):Observable<Product>{
    var contentData = "farmerId="+farmerId
                      +"&productName="+newProduct.productName
                      +"&productDescription="+newProduct.productDescription
                      +"&productType="+newProduct.productType
                      +"&productPrice="+newProduct.productPrice
                      +"&productQuantity="+newProduct.productQuantity
                      +"&productWeightKG="+newProduct.productWeightKG

    const httpOptions={
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"})
    }
    
    return this.httpsvc.post<Product>(
    this.rootURL+"/product/register", // URL
    contentData, // data for the server
    httpOptions) // header options
  }
  getProducts():Observable<Product[]>{
    return this.httpsvc.get<Product[]>
    (this.rootURL+"/product/list")
  }

  addProductsToOrder(orderId:number, productId: number, newProduct:Product):Observable<Product[]>{
    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
      }
      var reqBody = "orderId"+orderId+"&productId"+productId

      return this.httpsvc.post<Product[]>(
        this.rootURL+"/product/item/register", reqBody, httpOpts
      )
      
    }
    addProductToBasket(basketID:number,productID: number):Observable<Product[]>{
      const httpOpts ={
        headers: new HttpHeaders(
          {'Content-Type':
          'application/x-www-form-urlencoded;charset=UTF-8'})
        }
  
        var reqBody = "basketID="+basketID+"&productID="+productID
  
        return this.httpsvc.post<Product[]>(
          this.rootURL+"basket/basketProducts", reqBody, httpOpts
        )
    }
    
  }
