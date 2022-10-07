import {AbstractFile} from './abstractfile.interface';

export interface Paper{
  id: number;
  title: string;
  paperFile: string;
  abstractFile: AbstractFile;
}
