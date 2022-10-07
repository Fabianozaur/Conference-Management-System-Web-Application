import {Component, OnInit} from '@angular/core';
import {ConferenceService} from '../conference.service';
import {Conference} from '../conference.interface';
import {Router} from '@angular/router';

@Component({
  selector: 'app-conference-list',
  templateUrl: './conference-list.component.html',
  styleUrls: ['./conference-list.component.css']
})
export class ConferenceListComponent implements OnInit {
  headers = ['Name', 'StartDate', 'EndDate', 'DeadlineAbstract', 'DeadlineProposal', 'ProgramCommittee'];
  public conferences: Conference[];
  public showDetails: Map<string, boolean> = new Map<string, boolean>();

  constructor(private service: ConferenceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getConferences();
  }

  getConferences(): void {
    this.service.getAllConferences().subscribe(conferences => this.conferences = conferences, (error) => {
      console.log(error);
    });
  }

  expand(ID: string): void {
    this.conferences.forEach(
      conference => {
        if (String(conference.id) !== ID) {
          this.showDetails.set(conference.id, false);
        }
      }
    );
    this.showDetails.set(ID, !this.showDetails.get(ID));
  }

  setCurrentConference(conference: Conference): void {
    this.service.SetCurrentConference(conference);
  }

  goToSections(): void {
    this.router.navigate(['/section']);
  }
}
