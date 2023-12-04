import { Component } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  constructor(private db: AuthenticationService){}

  loggedUser: { firstName: string; lastName: string; email: string; exp1: string; empresa1: string; period1: string; exp2: string; empresa2: string; period2: string; exp3: string; empresa3: string; period3: string } | null = this.db.getUserInfo();

  logout(): void {
    this.db.logout();
    window.location.reload();
  }
}
