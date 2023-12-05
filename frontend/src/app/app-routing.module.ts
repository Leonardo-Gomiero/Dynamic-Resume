import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { ResumeComponent } from './components/resume/resume.component';
import { UserPostComponent } from './components/userPost/userPost.component';

const routes: Routes = [
  {
    path: '',
    component: UserPostComponent
  },
  {
    path: 'posts',
    component: UserPostComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'resume',
    component: ResumeComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
