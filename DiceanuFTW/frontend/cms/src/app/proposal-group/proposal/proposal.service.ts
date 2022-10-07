import {Injectable} from '@angular/core';
import {Proposal} from './proposal.interface';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Conference} from '../../conference/conference.interface';

@Injectable({
  providedIn: 'root'
})
export class ProposalService {
  private url = 'http://localhost:8080/proposal';
  private currentProposal: Proposal | undefined;

  constructor(private httpClient: HttpClient) {
  }


  getAllProposals(): Observable<Proposal[]> {
    return this.httpClient
      .get<Array<Proposal>>(this.url);
  }


  saveProposal(proposal: Proposal): Observable<Proposal> {
    return this.httpClient
      .post<Proposal>(this.url, proposal);
  }



}
