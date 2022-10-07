import {Component, OnInit} from '@angular/core';
import {ProposalService} from '../proposal/proposal.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {Proposal} from '../proposal/proposal.interface';

@Component({
  selector: 'app-proposal-list',
  templateUrl: './proposal-list.component.html',
  styleUrls: ['./proposal-list.component.css']
})
export class ProposalListComponent implements OnInit {
  headers = ['name', 'keywords', 'topics'];
  public proposals: Proposal[];

  constructor(private service: ProposalService, private router: Router) {
  }

  ngOnInit(): void {
    this.getProposals();
  }

  getProposals(): void {
    this.service.getAllProposals().subscribe(proposals => this.proposals = proposals, (error) => {
      console.log(error);
    });  }

  goToReview(): void {
    this.router.navigate(['proposal/review']);
  }

  goToAuthors(): void {
    this.router.navigate(['/author']);
  }
}
