import {Author} from '../components/author-group/author/author.interface';

export class Section {
  id: string;
  sectionName: string;
  supervisor: Author;
  noOfParticipants: number;
  roomNumber: string;
}
