import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Conference} from '../conference.interface';
import {ConferenceService} from '../conference.service';

@Component({
  selector: 'app-conference-details',
  templateUrl: './conference-details.component.html',
  styleUrls: ['./conference-details.component.css']
})
export class ConferenceDetailsComponent implements OnInit {
  Conference = new FormGroup({
    DeadlineAbstract: new FormControl(),
    DeadlineProposal: new FormControl(),
  });

  currentConference: Conference | undefined;

  constructor(private service: ConferenceService) {
  }

  ngOnInit(): void {
    this.currentConference = this.getCurrentConference();
  }

  getCurrentConference(): Conference {
    return this.service.GetCurrentConference();
  }

  updateConference(deadlineAbstract: Date, deadlineProposal: Date): void {
    this.currentConference.deadlineAbstract = deadlineAbstract;
    this.currentConference.deadlineProposal = deadlineProposal;
    this.service.updateConference(this.currentConference)
      .subscribe(conference => console.log('updated conference: ', conference));
  }
}
