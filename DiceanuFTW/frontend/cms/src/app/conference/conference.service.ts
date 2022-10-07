import {Injectable} from '@angular/core';
import {Conference} from './conference.interface';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {

  private url = 'http://localhost:8080/conferences';

  private currentConference: Conference | undefined;

  constructor(private httpClient: HttpClient) {
  }

  getAllConferences(): Observable<Conference[]> {
    return this.httpClient
      .get<Array<Conference>>(this.url);
    // const conference1: Conference = {
    //   ID: '1',
    //   Name: 'conf1',
    //   StartDate: new Date(2020, 2, 1),
    //   EndDate: new Date(2020, 3, 1),
    //   DeadlineAbstract: new Date(2020, 2, 10),
    //   DeadlineProposal: new Date(2020, 2, 10),
    //   ProgramCommittee: 'pc1'
    // };
    //
    // const conference2: Conference = {
    //   ID: '2',
    //   Name: 'conf2',
    //   StartDate: new Date(2020, 2, 1),
    //   EndDate: new Date(2020, 3, 1),
    //   DeadlineAbstract: new Date(2020, 2, 10),
    //   DeadlineProposal: new Date(2020, 2, 10),
    //   ProgramCommittee: 'pc2',
    // };
    //
    // const conference3: Conference = {
    //   ID: '3',
    //   Name: 'conf3',
    //   StartDate: new Date(2020, 2, 1),
    //   EndDate: new Date(2020, 3, 1),
    //   DeadlineAbstract: new Date(2020, 2, 10),
    //   DeadlineProposal: new Date(2020, 2, 10),
    //   ProgramCommittee: 'pc3',
    // };
    //
    // const conference4: Conference = {
    //   ID: '4',
    //   Name: 'conf4',
    //   StartDate: new Date(2020, 2, 1),
    //   EndDate: new Date(2020, 3, 1),
    //   DeadlineAbstract: new Date(2020, 2, 10),
    //   DeadlineProposal: new Date(2020, 2, 10),
    //   ProgramCommittee: 'pc4',
    // };
    //
    // return [conference1, conference2, conference3, conference4];
  }

  public SetCurrentConference(conference: Conference): void {
    this.currentConference = conference;
  }

  public GetCurrentConference(): Conference {
    return this.currentConference as Conference;
  }

  saveConference(conference: Conference): Observable<Conference> {
    return this.httpClient
      .post<Conference>(this.url, conference);
  }

  updateConference(conference: Conference): Observable<Conference> {
    window.alert(conference.deadlineAbstract);
    return this.httpClient
      .put<Conference>(this.url, conference);
  }
}
