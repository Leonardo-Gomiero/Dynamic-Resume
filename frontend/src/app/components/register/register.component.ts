import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/components/model/user';
import { AuthenticationService } from 'src/app/services/authentication.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  mostrarSenha = false;
  toggleMostrarSenha() {
    this.mostrarSenha = !this.mostrarSenha;
  }

  constructor(private db: AuthenticationService, private router: Router){ }

  loginUser: {email: string, password: string} = {email:'', password:''};
  loggedUser: { firstName: string; lastName: string; email: string; exp1: string; empresa1: string; period1: string; exp2: string; empresa2: string; period2: string; exp3: string; empresa3: string; period3: string; acaTit1: string; acaCon1: string; acaTit2: string; acaCon2: string; lan1: string; lanLv1: string; lan2: string; lanLv2: string; hardSkl1: string; hardSkl2: string; hardSkl3: string; softSkl1: string; softSkl2: string; softSkl3: string } | null = { firstName: '', lastName: '', email: '', exp1: '', empresa1: '', period1: '', exp2: '', empresa2: '', period2: '', exp3: '', empresa3: '', period3: '', acaTit1: '', acaCon1: '', acaTit2: '', acaCon2: '', lan1: '', lanLv1: '', lan2: '', lanLv2: '', hardSkl1: '', hardSkl2: '', hardSkl3: '', softSkl1: '', softSkl2: '', softSkl3: '' }

  login(){
    this.db.login(this.loginUser);
    this.loggedUser = this.db.getUserInfo();
  }

  user: User = new User();
  submitted = false;

  save() {
    this.db.register(this.user);
  }

  onSubmit() {
    this.submitted = true;
    this.save();
    this.inverteFlag();
  }

  cadastroFlag: boolean = false;

  inverteFlag() {
    this.cadastroFlag = !this.cadastroFlag;
  }
}
