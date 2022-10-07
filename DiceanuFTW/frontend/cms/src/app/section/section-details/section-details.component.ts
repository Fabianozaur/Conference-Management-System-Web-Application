import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Section} from '../section.interface';
import {SectionService} from '../section.service';

@Component({
  selector: 'app-section-details',
  templateUrl: './section-details.component.html',
  styleUrls: ['./section-details.component.css']
})
export class SectionDetailsComponent implements OnInit {
  Section = new FormGroup({
    Supervisor: new FormControl(),
    Room: new FormControl(),
  });

  currentSection: Section | undefined;

  constructor(private service: SectionService) {
  }

  ngOnInit(): void {
    this.currentSection = this.getCurrentSection();
  }

  getCurrentSection(): Section {
    return this.service.GetCurrentSection();
  }

  updateSection(roomNumber: string): void {
    this.currentSection.roomNumber = roomNumber;
    this.service.updateSection(this.currentSection)
      .subscribe(section => console.log('updated section: ', section));
  }

}
