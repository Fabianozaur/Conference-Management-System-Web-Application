import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthorService} from '../author/author.service';

@Component({
  selector: 'app-author-new',
  templateUrl: './author-new.component.html',
  styleUrls: ['./author-new.component.css']
})
export class AuthorNewComponent implements OnInit {

  author = new FormGroup({
    // Name: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Email: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),

  });

  constructor(private service: AuthorService) {
  }

  get email(): string {
    return this.author?.get('Email')?.value;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.email);
    if (this.email) {
      this.service.makeUserAuthor(this.email)
        .subscribe(
          result => console.log(result)
        );
    }
  }

}
