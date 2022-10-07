import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProposalService} from '../proposal/proposal.service';

@Component({
  selector: 'app-proposal-review',
  templateUrl: './proposal-review.component.html',
  styleUrls: ['./proposal-review.component.css']
})
export class ProposalReviewComponent implements OnInit {
  proposal = new FormGroup({
    Name: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Keywords: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Topics: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Authors: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),

  });


  constructor(private service: ProposalService) {
  }

  ngOnInit(): void {
  }

}
