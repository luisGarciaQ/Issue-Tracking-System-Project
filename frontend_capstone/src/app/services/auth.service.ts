import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginRequest } from '../models/LoginRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url: string = 'http://localhost:8081/';  // Adjust the URL as needed

  constructor(private http: HttpClient) {}

  // Method to authenticate the login request
  authenticateLogin(login: LoginRequest): Observable<string> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    // Send the login request to the backend
    return this.http.post<string>(this.url + 'user/verify', login, { headers, responseType: 'text' as 'json' });
  }
}
