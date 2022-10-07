import {Component, OnInit} from '@angular/core';
import {SectionService} from '../section.service';
import {Section} from '../section.interface';

@Component({
  selector: 'app-section-list',
  templateUrl: './section-list.component.html',
  styleUrls: ['./section-list.component.css']
})
export class SectionListComponent implements OnInit {
  headers = ['Name', 'Supervisor', 'NumberOfParticipants', 'Room'];
  public sections: Section[];
  public showDetails: Map<string, boolean> = new Map<string, boolean>();

  constructor(private service: SectionService) {
  }

  ngOnInit(): void {
    this.getSections();
  }

  getSections(): void {
    this.service.getAllSections().subscribe(sections => this.sections = sections, (error) => {
      console.log(error);
    });
  }

  expand(ID: string): void {
    this.sections.forEach(
      section => {
        if (section.id !== ID) {
          this.showDetails.set(section.id, false);
        }
      }
    );
    this.showDetails.set(ID, !this.showDetails.get(ID));
  }

  setCurrentSection(section: Section): void {
    this.service.SetCurrentSection(section);
  }

}
