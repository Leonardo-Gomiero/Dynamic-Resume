import { Component } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  constructor(private db: AuthenticationService){}

  loggedUser: {firstName: string; lastName: string; email: string; exp1: string; empresa1: string; period1: string; exp2: string; empresa2: string; period2: string; exp3: string; empresa3: string; period3: string; acaTit1: string; acaCon1: string; acaTit2: string; acaCon2: string; lan1: string; lanLv1: string; lan2: string; lanLv2: string; hardSkl1: string; hardSkl2: string; hardSkl3: string; softSkl1: string; softSkl2: string; softSkl3: string } | null = this.db.getUserInfo();

  logout(): void {
    this.db.logout();
    window.location.reload();
  }
}
