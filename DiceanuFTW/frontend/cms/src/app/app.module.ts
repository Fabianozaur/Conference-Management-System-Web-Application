import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppRoutingModule} from './app-routing.module';
import {ConferenceComponent} from './conference/component/conference.component';
import {HttpClientModule} from '@angular/common/http';
import {ConferenceNewComponent} from './conference/conference-new/conference-new.component';
import {ConferenceListComponent} from './conference/conference-list/conference-list.component';
import {ProposalComponent} from './proposal-group/proposal/proposal.component';
import {ProposalNewComponent} from './proposal-group/proposal-new/proposal-new.component';
import {ProposalListComponent} from './proposal-group/proposal-list/proposal-list.component';
import {MatNativeDateModule} from '@angular/material/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatFileUploadModule} from 'angular-material-fileupload';
import {ProposalReviewComponent} from './proposal-group/proposal-review/proposal-review.component';
import {MatButtonModule} from '@angular/material/button';
import {MatDividerModule} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';
import {LoginComponent} from './components/login/login.component';
import {ConferenceDetailsComponent} from './conference/conference-details/conference-details.component';
import {SectionComponent} from './section/component/section.component';
import {SectionListComponent} from './section/section-list/section-list.component';
import {SectionDetailsComponent} from './section/section-details/section-details.component';
import {SectionNewComponent} from './section/section-new/section-new.component';
import {AuthorListComponent} from './components/author-group/author-list/author-list.component';
import {AuthorComponent} from './components/author-group/author/author.component';
import {AuthorNewComponent} from './components/author-group/author-new/author-new.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AppComponent,
    ProposalComponent,
    ProposalNewComponent,
    ProposalListComponent,
    ProposalReviewComponent,
    AuthorComponent,
    AuthorListComponent,
    AuthorNewComponent,
    ConferenceComponent,
    ConferenceNewComponent,
    ConferenceListComponent,
    ConferenceDetailsComponent,
    SectionComponent,
    SectionListComponent,
    SectionDetailsComponent,
    SectionNewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NgbModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatInputModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatButtonModule,
    MatIconModule,
    NgbModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    FormsModule,
    MatFormFieldModule,
    HttpClientModule,
    MatIconModule,
    MatInputModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatInputModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatFileUploadModule,
    MatButtonModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
