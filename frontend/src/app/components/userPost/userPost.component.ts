import { Component } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { Post } from '../model/post';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Observable, tap } from 'rxjs';

@Component({
  selector: 'app-post',
  templateUrl: './userPost.component.html',
  styleUrls: ['./userPost.component.css']
})
export class UserPostComponent {

  constructor(private db: PostService, private auth: AuthenticationService, private router: Router) { }

  user = this.auth.getUserInfo()?.firstName + " " + this.auth.getUserInfo()?.lastName
  post: Post = new Post(this.user);
  submitted = false;

  posts!: Observable<Post[]>;

  ngOnInit(){
    this.reloadData();
  }

  save() {
    this.db.createPost(this.post).subscribe(data => {
      console.log(data);
      this.post = new Post(this.user);
    },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;


    this.save();
    this.reloadPage();
  }

  reloadPage() {

    window.location.reload()
  }

  reloadData() {
    this.posts = this.db.getPostsList();
    this.posts = this.posts.pipe(
      tap(results => {
        results.sort((a: Post, b: Post) => {
          let da: any = new Date(a.timestamp),
            db: any = new Date(b.timestamp);
          return db - da;
        })
      })
    )
  }
}


