import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProposalService} from '../proposal/proposal.service';
import {AuthorService} from '../../components/author-group/author/author.service';
import {Conference} from '../../conference/conference.interface';
import {Proposal} from '../proposal/proposal.interface';

@Component({
  selector: 'app-proposal-new',
  templateUrl: './proposal-new.component.html',
  styleUrls: ['./proposal-new.component.css']
})
export class ProposalNewComponent implements OnInit {
  proposal = new FormGroup({
    Name: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Keywords: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Topics: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9 ]*$')]),
    Author: new FormControl(),
  });


  public Authors: Array<any> = [];

  constructor(private proposalService: ProposalService, private authorService: AuthorService) {
  }

  ngOnInit(): void {
    this.authorService.getAllAuthors().subscribe(autho => this.Authors = autho);
  }

  addAuthors(): void {
    const authorsName = this.proposal.controls.Author.value;
    this.proposal.controls.Author.reset();
    if (authorsName !== null) {
      this.Authors.push(authorsName);
    }
  }

  addProposal(name: string, keywords: string, topics: string): void {

    const propsal = { name, keywords, topics} as Proposal;
    this.proposalService.saveProposal(propsal)
      // tslint:disable-next-line:no-shadowed-variable
      .subscribe(propsal => console.log('saved proposal: ', propsal));
    window.alert(propsal);
  }


}
