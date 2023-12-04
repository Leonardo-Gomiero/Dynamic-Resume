import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private router: Router) { }

  baseUrl: string = "http://localhost:8080/auth"

  private jwtHelper: JwtHelperService = new JwtHelperService();

  login(user: any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': 'true'
      })
    };
    return this.http.post(`${this.baseUrl}/login`, JSON.stringify(user), httpOptions).subscribe(data => {
      localStorage.setItem('access_token', JSON.parse(JSON.stringify(data)).token)
      console.info(JSON.parse(JSON.stringify(data)).token);
      this.router.navigate(['resume']);
      // window.location.reload();
    });
  }

  logout(): void {
    // Remove o token do localStorage
    localStorage.removeItem('access_token');
  }

  register(user: object) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': 'true'
      })
    };

    return this.http.post(`${this.baseUrl}/register`, JSON.stringify(user), httpOptions).subscribe(data => {
      console.log(data);
    });
  }

  getUserInfo(): { firstName: string; lastName: string; email: string; exp1: string; empresa1: string; period1: string; exp2: string; empresa2: string; period2: string; exp3: string; empresa3: string; period3: string } | null {
    const token = localStorage.getItem('access_token');

    if (token && !this.jwtHelper.isTokenExpired(token)) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      console.log(decodedToken);

      return {
        firstName: decodedToken.firstName,
        lastName: decodedToken.lastName,
        email: decodedToken.email,
        exp1: decodedToken.exp1,
        empresa1: decodedToken.empresa1,
        period1: decodedToken.period1,
        exp2: decodedToken.exp2,
        empresa2: decodedToken.empresa2,
        period2: decodedToken.period2,
        exp3: decodedToken.exp3,
        empresa3: decodedToken.empresa3,
        period3: decodedToken.period3,
      };
    }

    return null;
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem('access_token');
    // Verifica se há um token e se não está expirado
    return !!token && !this.jwtHelper.isTokenExpired(token);
  }
}
