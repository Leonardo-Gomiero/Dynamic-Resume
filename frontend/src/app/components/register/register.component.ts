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
  loggedUser: { firstName: string; lastName: string; email: string; exp1: string; empresa1: string; period1: string; exp2: string; empresa2: string; period2: string; exp3: string; empresa3: string; period3: string } | null = { firstName: '', lastName: '', email: '', exp1: '', empresa1: '', period1: '', exp2: '', empresa2: '', period2: '', exp3: '', empresa3: '', period3: '' }

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
