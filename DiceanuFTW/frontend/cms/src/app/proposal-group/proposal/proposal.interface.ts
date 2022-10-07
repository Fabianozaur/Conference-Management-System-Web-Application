import {Paper} from './paper.interface';
import {Review} from '../proposal-review/proposal-review.interface';
import {Author} from '../../components/author-group/author/author.interface';

export interface Proposal{
  id: number;
  name: string;
  keywords: string;
  topics: string;
  // paper: Paper;
  // authors: Array<Author>;
  // reviews: Array<Review>;
}
