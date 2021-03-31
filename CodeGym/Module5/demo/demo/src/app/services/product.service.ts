import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public API_PRODUCT = ' http://localhost:3000/product';
  public API_CATEGORY = ' http://localhost:3000/loaiVe';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllCategory(): Observable<any> {
    return this.http.get(this.API_CATEGORY);
  }

  getAllProduct(): Observable<any> {
    return this.http.get(this.API_PRODUCT);
  }

  createNewProductService(product): Observable<any> {
    return this.http.post(this.API_PRODUCT, product);
  }

  getProductById(productId): Observable<any> {
    return this.http.get(this.API_PRODUCT + '/' + productId);
  }

  editProduct(product, productId): Observable<any> {
    return this.http.put(this.API_PRODUCT + '/' + productId, product);
  }

  deleteProduct(productId): Observable<any> {
    return this.http.delete(this.API_PRODUCT + '/' + productId);
  }

}
