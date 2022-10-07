import {Component, OnInit} from '@angular/core';
import {AuthorService} from '../author/author.service';
import {Router} from '@angular/router';
import {Author} from '../author/author.interface';

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {

  headers = ['name', 'email'];
  // public Authors: Array<any> [];
  public Authors: Author[];

  constructor(private service: AuthorService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAuthors();
  }

  getAuthors(): void {
    this.service.getAllAuthors()
      .subscribe(authors => {
        // this.Authors = authors.map(author => Object.keys(author));
        this.Authors = authors;
        this.Authors.forEach(auth => console.log(auth));
      });
  }


}
