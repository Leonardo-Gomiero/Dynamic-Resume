import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { CurriculoComponent } from './pages/curriculo/curriculo.component';
import { NetworkComponent } from './pages/network/network.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './pages/login/login.component';
import { PostsComponent } from './components/posts/posts.component';
import { RegisterComponent } from './components/register/register.component';
import { ResumeComponent } from './components/resume/resume.component';
import { UserPostComponent } from './components/userPost/userPost.component';

const routes: Routes = [
  {
    path: '',
    component: PostsComponent
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
