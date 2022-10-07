import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Section} from '../section.interface';
import {SectionService} from '../section.service';
import {Author} from '../../components/author-group/author/author.interface';

@Component({
  selector: 'app-section-new',
  templateUrl: './section-new.component.html',
  styleUrls: ['./section-new.component.css']
})
export class SectionNewComponent implements OnInit {
  Section = new FormGroup({
    Name: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Supervisor: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Room: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
  });

  constructor(private service: SectionService) {
  }

  ngOnInit(): void {
  }

  addSection(sectionName: string, roomNumber: string): void {
    const supervisor: Author = new Author(10, 'lala', 'dicianuioanalexandru@gmail.com');
    const section = {sectionName, supervisor, noOfParticipants: +0, roomNumber} as Section;
    this.service.saveSection(section)
      // tslint:disable-next-line:no-shadowed-variable
      .subscribe(section => console.log('saved section: ', section));
  }

}
