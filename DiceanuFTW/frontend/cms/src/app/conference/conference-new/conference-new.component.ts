import {Component, OnInit} from '@angular/core';
import {ConferenceService} from '../conference.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Conference} from '../conference.interface';
import {SectionService} from '../../section/section.service';

@Component({
  selector: 'app-conference-new',
  templateUrl: './conference-new.component.html',
  styleUrls: ['./conference-new.component.css']
})
export class ConferenceNewComponent implements OnInit {
  addedConference = new FormGroup({
    Name: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    StartDate: new FormControl('', Validators.required),
    EndDate: new FormControl('', Validators.required),
    DeadlineAbstract: new FormControl(),
    DeadlineProposal: new FormControl('', Validators.required),
    ProgramCommittee: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z]*$')]),
    Section: new FormControl(),
  });

  public Sections: Array<any> = [];

  constructor(private service: ConferenceService, private sectionService: SectionService) {
  }

  ngOnInit(): void {
    this.sectionService.getAllSections().subscribe(sections => this.Sections = sections);
  }

  addSection(): void {
    const sectionName = this.addedConference.controls.Section.value;
    this.addedConference.controls.Section.reset();
    if (sectionName !== null) {
      this.Sections.push(sectionName);
    }
  }

  addConference(name: string, startDate: Date, endDate: Date, deadlineAbstract: Date, deadlineProposal: Date): void {
    const conference = {name, startDate, endDate, deadlineAbstract, deadlineProposal} as Conference;
    this.service.saveConference(conference)
      // tslint:disable-next-line:no-shadowed-variable
      .subscribe(conference => console.log('saved conference: ', conference));
    window.alert(conference);
  }

}
