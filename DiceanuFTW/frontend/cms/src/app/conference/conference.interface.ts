// import {Author} from '../author-group/author/author.interface';

export interface Conference {
  id: string;
  name: string;
  startDate: Date;
  endDate: Date;
  deadlineAbstract: Date;
  deadlineProposal: Date;
  // ProgramCommittee: Array<Author>;
}
