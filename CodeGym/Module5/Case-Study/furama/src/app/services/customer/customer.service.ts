import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API_CUSTOMER = 'http://localhost:3000/customers';
  public API_TYPE_CUSTOMER = 'http://localhost:3000/customerType';

  constructor(public http: HttpClient) {
  }

  getAllCustomer(): Observable<any> {
    return this.http.get(this.API_CUSTOMER);
  }

  getAllTypeCustomer(): Observable<any> {
    return this.http.get(this.API_TYPE_CUSTOMER);
  }

  createNewCustomerService(customer): Observable<any> {
    return this.http.post(this.API_CUSTOMER, customer);
  }

  deleteCustomer(customerId): Observable<any> {
    return this.http.delete(this.API_CUSTOMER + '/' + customerId);
  }

  getCustomerById(customerId): Observable<any> {
    return this.http.get(this.API_CUSTOMER + '/' + customerId);
  }

  editCustomer(customer, customerId): Observable<any> {
    return this.http.put(this.API_CUSTOMER + '/' + customerId, customer);
  }


  findById(idNeedFind: any): Observable<any> {
    return this.http.get(this.API_CUSTOMER + '/' + idNeedFind);
  }
}
