import {Injectable} from "@angular/core";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {CurrencyValue, MedicalOperationI} from "../../Shared/MedicalOperation.entity";
import {environment} from "../../Shared/environment";

@Injectable({
  providedIn: 'root'
})

export class MedicalOperationService {
  constructor(private http: HttpClient) {
  }

  createMedicalOperation(name:string, price:CurrencyValue): Observable<MedicalOperationI> {
    return this.http.post<MedicalOperationI>(`${environment.apiUrl}/operation`, {name, price});
  }

}

