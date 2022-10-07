import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ConferenceComponent} from './conference/component/conference.component';
import {ConferenceNewComponent} from './conference/conference-new/conference-new.component';
import {SectionComponent} from './section/component/section.component';
import {SectionNewComponent} from './section/section-new/section-new.component';
import {LoginComponent} from './components/login/login.component';
import {ProposalComponent} from './proposal-group/proposal/proposal.component';
import {ProposalNewComponent} from './proposal-group/proposal-new/proposal-new.component';
import {ProposalReviewComponent} from './proposal-group/proposal-review/proposal-review.component';
import {AuthorComponent} from './components/author-group/author/author.component';
import {AuthorNewComponent} from './components/author-group/author-new/author-new.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'proposal', component: ProposalComponent},
  {path: 'proposal/add', component: ProposalNewComponent},
  {path: 'proposal/review', component: ProposalReviewComponent},
  {path: 'author', component: AuthorComponent},
  {path: 'author/add', component: AuthorNewComponent},
  {path: 'conference', component: ConferenceComponent},
  {path: 'conference/add', component: ConferenceNewComponent},
  {path: 'section', component: SectionComponent},
  {path: 'section/add', component: SectionNewComponent},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
